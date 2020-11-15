package cookies;

import cookies.recipe.*;

import java.util.*;


public class CookieFactory {

    private Set<Store> storeList;
    private Set<Dough> doughList;
    private Set<Topping> toppingList;
    private Set<Mix> mixList;
    private Set<Flavour> flavourList;
    private Set<Cooking> cookingList;
    private Set<Recipe> recipesList;
    private Map<Recipe,Integer>map;


    public CookieFactory() {
        storeList = new HashSet<>();
        doughList = new HashSet<>();
        toppingList = new HashSet<>();
        mixList = new HashSet<>();
        flavourList = new HashSet<>();
        cookingList = new HashSet<>();
        recipesList = new HashSet<>();
        this.map=new HashMap<>();
        initStoreList();
        initDoughList();
        initToppingList();
        initMixList();
        initFlavourList();
        initCookingList();
        initRecipeList();
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
    }

    public void setMap(){
        for(Recipe recipe:recipesList)
            if(!map.containsKey(recipe))
                map.put(recipe,0);
    }

    private void initDoughList(){
        doughList.add(new Dough("Plain",2.0));
        doughList.add(new Dough("Chocolate",2.4));
        doughList.add(new Dough("Peanut butter",2.5));
        doughList.add(new Dough("Oatmeal",2.6));
    }

    private  void initToppingList(){
        toppingList.add(new Topping("White chocolate",0.2));
        toppingList.add(new Topping("Milk chocolate",0.2));
        toppingList.add(new Topping("M&M’s™",0.3));
        toppingList.add(new Topping("Reese’s buttercup",0.4));
    }

    private void initMixList(){
        mixList.add(new Mix("Mixed",0.2));
        mixList.add(new Mix("Topped",0.3));
    }

    private void initFlavourList(){
        flavourList.add(new Flavour("Vanilla",0.1));
        flavourList.add(new Flavour("Cinnamon",0.1));
        flavourList.add(new Flavour("Chili",0.1));
    }

    private void initCookingList(){
        cookingList.add(new Cooking("Crunchy",0.3));
        cookingList.add(new Cooking("Chewy",0.4));
    }

    private void initRecipeList() {
        Recipe recipe1 = new Recipe("recipe1");
        recipe1.setDough(new Dough("Plain",2.0));
        recipe1.setFlavour(new Flavour("Vanilla",0.1));
        Topping[] toppings1 = new Topping[3];
        toppings1[0] = new Topping("White chocolate",0.2);
        recipe1.setToppings(toppings1);
        recipe1.setMix(new Mix("Mixed",0.2));
        recipe1.setCooking(new Cooking("Crunchy",0.3));
        recipesList.add(recipe1);

        Recipe recipe2 = new Recipe("recipe2");
        recipe2.setDough(new Dough("Chocolate",2.4));
        recipe2.setFlavour(new Flavour("Cinnamon",0.1));
        Topping[] toppings2 = new Topping[3];
        toppings2[0] = new Topping("Milk chocolate",0.2);
        recipe2.setToppings(toppings2);
        recipe2.setMix(new Mix("Mixed",0.2));
        recipe2.setCooking(new Cooking("Chewy",0.4));
        recipesList.add(recipe2);
    }

    private void initStoreList() {
        storeList = new HashSet<>();
        Store store1 = new Store("store1","Biot",8,30,18,0,0.2);
        storeList.add(store1);
    }

    public Set<Recipe> getRecipesList() {
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
    }
    public void deleteStore(String name) {
        storeList.remove(getStore(name));
    }

    public Set<Store> getStoreList() {
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

    public Set<Store> getNearbyStores(Store store){
        Set<Store> nearbyStores = new HashSet<>();
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
}

