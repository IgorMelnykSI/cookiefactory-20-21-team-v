package cookies;

import cookies.recipe.*;

import java.util.*;


public class CookieFactory {

    private Set<Recipe> recipesList;
    private Set<Store> storeList;
    private Map<Recipe,Integer>map;


    public CookieFactory() {
        recipesList = new HashSet<>();
        storeList = new HashSet<>();
        this.map=new HashMap<>();
        initRecipeList();
        initStoreList();
    }

    public void resetFactory() {
        this.recipesList.clear();
        this.storeList.clear();
        initRecipeList();
        initStoreList();

    }

    public void setMap(){
        for(Recipe recipe:recipesList)
            if(!map.containsKey(recipe))
                map.put(recipe,0);
    }

    private void initRecipeList() {
        recipesList = new HashSet<>();
        Recipe recipe1 = new Recipe("recipe1");
        recipe1.setDough(new Dough("Plain"));
        recipe1.setFlavour(new Flavour("Vanilla"));
        Topping[] toppings1 = new Topping[3];
        toppings1[0] = new Topping("White chocolate");
        recipe1.setToppings(toppings1);
        recipe1.setMix(new Mix("Mixed"));
        recipe1.setCooking(new Cooking("Crunchy"));
        recipesList.add(recipe1);

        Recipe recipe2 = new Recipe("recipe2");
        recipe2.setDough(new Dough("Chocolate"));
        recipe2.setFlavour(new Flavour("Cinnamon"));
        Topping[] toppings2 = new Topping[3];
        toppings2[0] = new Topping("Milk chocolate");
        recipe2.setToppings(toppings2);
        recipe2.setMix(new Mix("Mixed"));
        recipe2.setCooking(new Cooking("Chewy"));
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



}

