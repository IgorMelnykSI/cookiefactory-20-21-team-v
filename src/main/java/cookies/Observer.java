package cookies;

import cookies.recipe.Recipe;

import java.util.List;

public interface Observer {
    void responseRecipeChange(List<Recipe> recipes);
    void response(List<Store> nearbyStore);
}
