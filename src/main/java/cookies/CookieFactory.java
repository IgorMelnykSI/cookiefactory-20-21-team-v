package cookies;

import cookies.recipe.*;

import java.lang.reflect.Array;
import java.util.*;


public class CookieFactory {

    private ArrayList<Store> storeList;
    private ArrayList<Dough> doughList;
    private ArrayList<Topping> toppingList;
    private ArrayList<Mix> mixList;
    private ArrayList<Flavour> flavourList;
    private ArrayList<Cooking> cookingList;
    private ArrayList<Recipe> recipesList;
    private HashMap<Recipe,Integer> map;
    private ToppingCreator toppingCreator;
    private FlavourCreator flavourCreator;
    private DoughCreator doughCreator;
    private ArrayList<Ingredient> ingredientList;

    public CookieFactory() {
        storeList = new ArrayList<>();
        doughList = new ArrayList<>();
        toppingList = new ArrayList<>();
        mixList = new ArrayList<>();
        flavourList = new ArrayList<>();
        cookingList = new ArrayList<>();
        recipesList = new ArrayList<>();
        ingredientList = new ArrayList<>();
        this.map=new HashMap<>();
        toppingCreator = new ToppingCreator();
        flavourCreator = new FlavourCreator();
        doughCreator = new DoughCreator();
        initStoreList();
        initDoughList();
        initToppingList();
        initMixList();
        initFlavourList();
        initCookingList();
        initRecipeList();
        initIngredientList();
    }

    public void resetFactory() {
        this.storeList.clear();
        this.doughList.clear();
        this.toppingList.clear();
        this.mixList.clear();
        this.flavourList.clear();
        this.cookingList.clear();
        this.recipesList.clear();
        initStoreList();
        initDoughList();
        initToppingList();
        initMixList();
        initFlavourList();
        initCookingList();
        initRecipeList();
        initIngredientList();
    }

    private void initIngredientList(){
        for(Dough dough:doughList){
            ingredientList.add(dough);
        }
        for(Flavour flavour:flavourList){
            ingredientList.add(flavour);
        }
        for(Topping topping:toppingList){
            ingredientList.add(topping);
        }

    }

    public void setMap(){
        for(Recipe recipe:recipesList)
            if(!map.containsKey(recipe))
                map.put(recipe,0);
            
    }

    private void initDoughList(){
        doughList.add(this.doughCreator.createIngredient("Plain",2.0));
        doughList.add(this.doughCreator.createIngredient("Chocolate",2.4));
        doughList.add(this.doughCreator.createIngredient("Peanut butter",2.5));
        doughList.add(this.doughCreator.createIngredient("Oatmeal",2.6));
    }

    public void addDough(Dough dough){
        doughList.add(dough);
    }
    private  void initToppingList(){
        toppingList.add(this.toppingCreator.createIngredient("White chocolate",0.2));
        toppingList.add(this.toppingCreator.createIngredient("Milk chocolate",0.2));
        toppingList.add(this.toppingCreator.createIngredient("M&M’s™",0.3));
        toppingList.add(this.toppingCreator.createIngredient("Reese’s buttercup",0.4));
    }

    private void initMixList(){
        mixList.add(new Mix("Mixed",0.2));
        mixList.add(new Mix("Topped",0.3));
    }

    private void initFlavourList(){
        flavourList.add(this.flavourCreator.createIngredient("Vanilla",0.1));
        flavourList.add(this.flavourCreator.createIngredient("Cinnamon",0.1));
        flavourList.add(this.flavourCreator.createIngredient("Chili",0.1));
    }

    private void initCookingList(){
        cookingList.add(new Cooking("Crunchy",0.3));
        cookingList.add(new Cooking("Chewy",0.4));
    }

    private void initRecipeList() {
        Recipe recipe1 = new Recipe("recipe1");
        recipe1.setDough(new Dough("Plain",2.0));
        recipe1.setFlavour(new Flavour("Vanilla",0.1));
        ArrayList<Topping> toppings1 = new ArrayList<>();
        toppings1.add(new Topping("White chocolate",0.2));
        recipe1.setToppings(toppings1);
        recipe1.setMix(new Mix("Mixed",0.2));
        recipe1.setCooking(new Cooking("Crunchy",0.3));
        recipe1.calculatePrice();
        recipesList.add(recipe1);


        Recipe recipe2 = new Recipe("recipe2");
        recipe2.setDough(new Dough("Chocolate",2.4));
        recipe2.setFlavour(new Flavour("Cinnamon",0.1));
        ArrayList<Topping> toppings2 = new ArrayList<>();
        toppings2.add(new Topping("Milk chocolate",0.2));
        recipe2.setToppings(toppings2);
        recipe2.setMix(new Mix("Mixed",0.2));
        recipe2.setCooking(new Cooking("Chewy",0.4));
        recipe2.calculatePrice();
        recipesList.add(recipe2);
    }

    private void initStoreList() {
        Store store1 = new Store("store1","Biot","8","30","18","0",0.2);
        storeList.add(store1);
    }

    public ArrayList<Recipe> getRecipesList() {
        return recipesList;
    }

    public Recipe getRecipe(String name) {
        for (Recipe r : this.recipesList) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public Store getStore(String name){
        for (Store s:storeList) {
            if(s.getName().equals(name))
                return s;
        }
        return null;
    }

    public void addRecipe(Recipe newRecipe) {
        recipesList.add(newRecipe);
        setMap();
        for(Store s:storeList){
            s.responseRecipeChange(recipesList);
        }
    }

    public void addCount(String recipeName) {
        int i = 0;
        for (Recipe recipe : map.keySet())
            if (recipeName.equals(recipe.getName())) {
                i=map.get(recipe)+1;
                map.put(recipe,i);
            }
    }

    public void deleteRecipe(String name) {
       recipesList.remove(getRecipe(name));
        for(Store s:storeList){
            s.responseRecipeChange(recipesList);
        }
    }

    public void deleteFewOrderRecipe(){
        Set<Recipe>set=map.keySet();
        Iterator<Recipe> it=set.iterator();
        while(it.hasNext())
        {
            Recipe recipe=(Recipe)it.next();
            int count=(int)map.get(recipe);
            if(count<5)
            {
                recipesList.remove(getRecipe(recipe.getName()));
                it.remove();
            }
        }
    }

    public void addStore(Store store) {
        storeList.add(store);
        store.updateAddAllIngredients(doughList, flavourList, toppingList);
        for(Store s: storeList){
            s.response(getNearbyStores(s));
        }
    }
    public void deleteStore(String name) {
        storeList.remove(getStore(name));
        for(Store s: storeList){
            s.response(getNearbyStores(s));
        }
    }

    public ArrayList<Store> getStoreList() {
        return storeList;
    }

    public Map<Recipe,Integer> getMap(){
        return this.map;
    }

    public void makeStoreHaveProblem(String name){
        getStore(name).setHasProblem(true);
    }

    public void fixStoreProblem(String name){
        getStore(name).setHasProblem(false);
    }

    public List<Store> getNearbyStores(Store store){
        List<Store> nearbyStores = new ArrayList<>();
        double distance = 0;
        for(Store s: storeList){
            if(s.getName().equals(store.getName())) continue;
            distance = Math.sqrt(Math.pow((s.getPosition()[0] - store.getPosition()[0]),2)
                    + Math.pow((s.getPosition()[1] - store.getPosition()[1]),2));
            if(distance < 5){
                nearbyStores.add(s);
            }
        }
        return nearbyStores;
    }

    public ArrayList<Cooking> getCookingList() {
        return cookingList;
    }

    public ArrayList<Dough> getDoughList() {
        return doughList;
    }

    public ArrayList<Flavour> getFlavourList() {
        return flavourList;
    }

    public ArrayList<Mix> getMixList() {
        return mixList;
    }

    public ArrayList<Topping> getToppingList() {
        return toppingList;
    }

    public Cooking getCooking(String name){
        for(Cooking cooking:this.cookingList){
            if(cooking.getType().equals(name)){
                return cooking;
            }
        }
        return null;
    }

    public Dough getDough(String name) {
        for(Dough dough:this.doughList){
            if(dough.getType().equals(name)){
                return dough;
            }
        }
        return null;
    }

    public Flavour getFlavour(String name) {
        for (Flavour flavour : this.flavourList) {
            if (flavour.getType ().equals (name)) {
                return flavour;
            }
        }
        return null;
    }

    public Mix getMix(String name) {
        for (Mix mix : this.mixList) {
            if (mix.getType ().equals (name)) {
                return mix;
            }
        }
        return null;
    }


    public Topping getTopping(String name) {
        for(Topping topping:this.toppingList){
            if(topping.getType().equals(name)){
                return topping;
            }
        }
        return null;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }
}

