package cookies.manager;

import cookies.CookieFactory;
import cookies.recipe.Recipe;

import java.util.Set;

public class BrandManager {
    private String name;
    private CookieFactory factory;
    private Recipe []recipes;
    private int [] countCookies;

    public BrandManager(String name){
        this.name = name;
        this.factory = new CookieFactory();
    }

    public void addRecipe(Recipe recipe){
        factory.addRecipe(recipe);
    }

    public void setRecipes(Set<Recipe> recipesList) {
        int i=0;
        for(Recipe recipe:recipesList)
            {
                recipes[i]=recipe;
                i++;
            }
    }

    public void setCountCookies(Recipe[] recipes){
        int i=0;
        for(Recipe recipe:recipes)
        {
            countCookies[i]=0;
            i++;
        }
    }

    public void addCount(String recipeName) {
        for(int i=0;i<recipes.length;i++){
            if(recipeName.equals(recipes[i].getName()))
                countCookies[i]++;
        }
    }

    public void deleteRecipe(){
        int minCountNumber=0;
        for(int i=1;i<countCookies.length;i++)
            if(countCookies[minCountNumber]>countCookies[i])
                minCountNumber=i;
        factory.deleteRecipe(recipes[minCountNumber].getName());
    }

    public CookieFactory getFactory() {
        return factory;
    }
}
