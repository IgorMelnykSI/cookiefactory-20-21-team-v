package cookies;

import cookies.recipe.*;

import java.util.*;


public class CookieFactory {

    private Set<Recipe> recipesList;
    private Set<Store> storeList;


    public CookieFactory() {
        recipesList = new HashSet<>();
        storeList = new HashSet<>();
        initRecipeList();
        initStoreList();
    }

    public void resetFactory() {
        this.recipesList.clear();
        this.storeList.clear();
        initRecipeList();
        initStoreList();

    }

    private void initRecipeList() {
        recipesList = new HashSet<>();
        Recipe recipe1 = new Recipe("recipe1",2.5);
        recipe1.setDough(new Dough("Plain"));
        recipe1.setFlavour(new Flavour("Vanilla"));
        Topping[] toppings1 = new Topping[3];
        toppings1[0] = new Topping("White chocolate");
        recipe1.setToppings(toppings1);
        recipe1.setMix(new Mix("Mixed"));
        recipe1.setCooking(new Cooking("Crunchy"));
        recipesList.add(recipe1);

        Recipe recipe2 = new Recipe("recipe2",3.5);
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
        Store store1 = new Store("store1","Biot","8:30","18:00",0.2);
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
    }

    public void deleteRecipe(String name) {
        recipesList.remove(getRecipe(name));
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



}

