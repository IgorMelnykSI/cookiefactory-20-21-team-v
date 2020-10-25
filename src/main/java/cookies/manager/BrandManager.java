package cookies.manager;

import cookies.recipe.Recipe;

import java.util.ArrayList;
import java.util.Iterator;

public class BrandManager {
    private ArrayList<Recipe>recipes=new ArrayList<>();

    public void addRecipe(Recipe recipe){
        for(Recipe recipe1:recipes)
            if(recipe1==recipe)
                return;
        recipes.add(recipe);
    }

    public void deleteRecipe(Recipe recipe){
        Iterator<Recipe> it= recipes.iterator();
        while(it.hasNext())
        {
            Recipe recipe1=it.next();
            if(recipe1==recipe)
                it.remove();
        }
    }
}
