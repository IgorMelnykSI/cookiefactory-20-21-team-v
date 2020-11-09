package cookies;
import cookies.Store;
import cookies.recipe.Recipe;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistique {


    public Map<String, Integer> computeRecipePopularity(List<Store> stores) {
        Map<String, Integer> historyRecipes = new HashMap<>();
        for (Store store : stores) {
            for (String name : computeRecipePopularity(store).keySet()) {
                if (historyRecipes.containsKey(name)) {
                    int number = historyRecipes.get(name);
                    historyRecipes.put(name, number + computeRecipePopularity(store).get(name));
                } else {
                    historyRecipes.put(name, computeRecipePopularity(store).get(name));
                }

            }
        }
        return historyRecipes;
    }

    public Map<String, Integer> computeRecipePopularity(Store store) {
        Map<String, Integer> historyRecipes = new HashMap<>();
        historyRecipes.put("personal", 0);
        return historyRecipes;
    }


}
