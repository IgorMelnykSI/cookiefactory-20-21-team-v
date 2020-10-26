package cookies.manager;

import cookies.CookieFactory;
import cookies.recipe.Recipe;

import java.util.ArrayList;
import java.util.Iterator;

public class BrandManager {
    private String name;
    private CookieFactory factory;

    public BrandManager(String name){
        this.name = name;
        this.factory = new CookieFactory();
    }
    public void addRecipe(Recipe recipe){
        factory.addRecipe(recipe);
    }

    public void deleteRecipe(String recipeName){
        factory.deleteRecipe(recipeName);
    }

    public CookieFactory getFactory() {
        return factory;
    }
}
