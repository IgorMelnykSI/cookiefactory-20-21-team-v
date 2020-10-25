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

    public void addRecipe(Recipe newRecipe) {
        recipesList.add(newRecipe);
    }

    public void deleteRecipe(String name) {
        Recipe recipe = getRecipe(name);
        Iterator<Recipe> iter = this.recipesList.iterator();
        while (iter.hasNext()) {
            Recipe rep = iter.next();
            if (rep.equals(recipe)) {
                iter.remove();
            }
        }
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public Set<Store> getStoreList() {
        return storeList;
    }



}

