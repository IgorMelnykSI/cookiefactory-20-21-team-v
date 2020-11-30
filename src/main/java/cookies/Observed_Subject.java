package cookies;

import cookies.recipe.Recipe;

public interface Observed_Subject {
    void addStore(Store store);
    void deleteStore(String name);
    void addRecipe(Recipe newRecipe);
    void deleteRecipe(String name);
}
