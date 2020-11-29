package cookies.manager;

import cookies.CookieFactory;
import cookies.recipe.Recipe;

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

    public CookieFactory getFactory() {
        return factory;
    }
}
