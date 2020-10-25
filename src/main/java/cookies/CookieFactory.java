package cookies;

import cookies.recipe.Recipe;

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
    }

    private void initStoreList() {
        storeList = new HashSet<>();
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

