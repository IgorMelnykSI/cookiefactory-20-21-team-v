package cookies;
import cookies.Store;
import cookies.recipe.Recipe;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {

    private List<Recipe> personalRecipes;
    private static Statistic instance;
    private Statistic (){
        personalRecipes = new ArrayList<>();
    }
    public static synchronized Statistic getInstance() {
        if (instance == null) {
            instance = new Statistic();
        }
        return instance;
    }

    public Recipe nationalBestOf() {
        if(personalRecipes.size()==0)
            return null;

        Recipe bestOf = personalRecipes.get(0);
        for(Recipe recipe:personalRecipes){
            if(recipe.getPopularity() > bestOf.getPopularity()){
                bestOf = recipe;
            }
        }

        return bestOf;
    }

    public Map<String, Integer> computeRecipePopularity(Store store) {
        Map<String, Integer> historyRecipes = new HashMap<>();
        historyRecipes.put("personal", 0);
        return historyRecipes;
    }

    public List<Recipe> getPersonalRecipes(){
        return personalRecipes;
    }

    public List<Recipe> addPersonalRecipes(Recipe recipe0){
        boolean exist=false;
        for(Recipe recipe1:personalRecipes){
            if(recipe1.compareRecipe(recipe0)){
                exist=true;
                recipe1.addPopularity();
            }
        }
        if(!exist){
            personalRecipes.add(recipe0);
            recipe0.addPopularity();
        }

        return personalRecipes;
    }


}
