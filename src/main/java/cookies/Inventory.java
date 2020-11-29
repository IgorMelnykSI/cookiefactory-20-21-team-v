package cookies;


import cookies.recipe.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    // all ingredients saved by id
    private Map<String, Integer> ingredientsList;

    public Inventory(){
        ingredientsList = new HashMap<>();
    }

    public void initIngredientQuantity(Integer quantity){
        CookieFactory factory = new CookieFactory();
        ArrayList<Ingredient> ingredients = factory.getIngredientList();
        for (Ingredient ingredient:ingredients) {
            this.ingredientsList.put(ingredient.getType(),quantity);
        }
    }
    /**
     * sets the quantity of the ingredient in the map as the quantity entered
     * @param ingredient is the item to update
     * @param quantity is the new quantity to put
     * @return false if the item does not exist, true if the item has been successfully updated
     */
    public boolean modifyIngredientQuantity(Ingredient ingredient, Integer quantity){
        if(ingredientsList.containsKey(ingredient.getType())) {
            ingredientsList.put(ingredient.getType(), quantity);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets every ingredients in the ingredientList to the given quantity
     * @param quantity amount to set
     */
    void modifyAllIngredientsQuantity(int quantity) {
        for (Map.Entry<String,Integer> entry : this.ingredientsList.entrySet()) {
            this.ingredientsList.put(entry.getKey(), quantity);
        }
    }

    /**
     * tells if an ingredient is available in the quantity asked
     * @param ingredient is the item to check
     * @param quantity is the quantity to check
     * @return true if there is enough of the ingredient, false otherwise
     */
    public boolean isIngredientAvailable(Ingredient ingredient, Integer quantity){
        return ingredientsList.containsKey(ingredient.getType()) && (quantity <= ingredientsList.get(ingredient.getType()));
    }

    /**
     * checks if a certain recipe is availabe in the given quantity
     * @param recipe
     * @param quantity
     * @return
     */
    private boolean isRecipeAvailable(Recipe recipe, int quantity) {
        if (!isIngredientAvailable(recipe.getDough(), quantity)
                || !isIngredientAvailable(recipe.getFlavour(), quantity))
            return false;
        for (Topping topping : recipe.getToppings()) {
            if (!isIngredientAvailable(topping, quantity))
                return false;
        }
        return true;
    }

    /**
     * checks if all recipes are available with the actual stocks
     * @param recipes is a map with a Recipe as the key and an Integer as the quantity
     * @return true if all recipes are available and false if at least one of the recipes is not available
     */
    boolean areRecipesAvailable(Map<Recipe, Integer> recipes) {
        for (Map.Entry<Recipe,Integer> entry : recipes.entrySet()) {
            if (!isRecipeAvailable(entry.getKey(), entry.getValue()))
                return false;
        }
        return true;
    }

    /**
     * updates the old stock value to the new one if it is possible
     * @param ingredient is the item to update
     * @param quantity is the quantity to subtract to the old one
     * @return the new value; if the old quantity is too small, -1 is returned
     */
    int subtractIngredientQuantity(Ingredient ingredient, Integer quantity) {
        if (this.isIngredientAvailable(ingredient, quantity)){
            Integer oldQuantity = ingredientsList.get(ingredient.getType());
            ingredientsList.put(ingredient.getType(), oldQuantity-quantity);
            return ingredientsList.get(ingredient.getType());
        } else return -1;
    }

    void addIngredientQuantity(Ingredient ingredient, Integer quantity) {
            if(ingredientsList.containsKey(ingredient.getType())) {
                Integer oldQuantity = ingredientsList.get(ingredient.getType());
                ingredientsList.put(ingredient.getType(), oldQuantity + quantity);
            }
    }

    /**
     * updates the quantity in the stocks of each ingredient used in the
     * recipe for a certain amount equal to the quantity given
     * @param recipe is the cookie to get the ingredients from
     * @param quantity is the multiplier to apply to the quantity of
     *                 ingredient to remove from the stocks
     */
    void updateRecipeQuantity(Recipe recipe, int quantity) {
        if (isRecipeAvailable(recipe, quantity)) {
            subtractIngredientQuantity(recipe.getDough(), quantity);
            subtractIngredientQuantity(recipe.getFlavour(), quantity);
            for (Topping topping : recipe.getToppings())
                subtractIngredientQuantity(topping, quantity);
        }

    }

    int getIngredientQuantity(Ingredient ingredient){
        if(ingredientsList.containsKey(ingredient.getType())) {
            return ingredientsList.get(ingredient.getType());
        }else
            return 0;
    }

    /**
     * updates the stocks after using the recipes given
     * @param recipes is the Map of Recipe (key) and quantity (value - Integer) which
     *                is to remove from the stocks
     */
    void updateAllQuantities(Map<Recipe, Integer> recipes) {
        if (areRecipesAvailable(recipes)) {
            for (Map.Entry<Recipe,Integer> entry : recipes.entrySet()) {
                updateRecipeQuantity(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * updates the list of ingredients available by removing an
     * ingredient removed from the CookieFactory
     * @param ingredient is the ingredient to remove
     */
    public void updateRemoveIngredient(Ingredient ingredient) {
        ingredientsList.remove(ingredient.getType());
    }

    /**
     * updates the list of ingredients available by adding an ingredient
     * added to the CookieFactory
     * @param ingredient is the ingredient to add
     */
    public void updateAddIngredient(Ingredient ingredient) {
        ingredientsList.put(ingredient.getType(),0);
    }


    public void updateAddAllIngredients(List<Dough> doughs, List<Flavour> flavours, List<Topping> toppings) {
        for(Dough dough : doughs) {
            ingredientsList.put(dough.getType(), 0);
        }
        for(Flavour flavour : flavours) {
            ingredientsList.put(flavour.getType(), 0);
        }
        for(Topping topping : toppings) {
            ingredientsList.put(topping.getType(), 0);
        }
    }
}
