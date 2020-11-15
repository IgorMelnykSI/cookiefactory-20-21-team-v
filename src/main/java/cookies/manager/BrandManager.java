package cookies.manager;

import cookies.CookieFactory;
import cookies.recipe.Recipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BrandManager {
    private String name;
    private CookieFactory factory;
    private Map<Recipe,Integer>map;


    public BrandManager(String name){
        this.name = name;
        this.factory = new CookieFactory();
        this.map=new HashMap<>();
    }

    public void addRecipe(Recipe recipe){
        factory.addRecipe(recipe);
        setMap(factory.getRecipesList());

    }

    public void setMap(Set<Recipe>recipesList){
        for(Recipe recipe:recipesList)
            if(!map.containsKey(recipe))
                map.put(recipe,0);
    }


    public void addCount(String recipeName) {
        int i = 0;
        for (Recipe recipe : map.keySet())
            if (recipeName.equals(recipe.getName())) {
                i=map.get(recipe)+1;
                map.put(recipe,i);
            }
    }

    public void deleteRecipe(){
        Set<Recipe>set=map.keySet();
        Iterator<Recipe> it=set.iterator();
        while(it.hasNext())
        {
            Recipe recipe=(Recipe)it.next();
            int count=(int)map.get(recipe);
            if(count<5)
            {
                factory.deleteRecipe(recipe.getName());
                it.remove();
            }
        }

    }

    public CookieFactory getFactory() {
        return factory;
    }

    public Map<Recipe,Integer> getMap(){
        return this.map;
    }


}
