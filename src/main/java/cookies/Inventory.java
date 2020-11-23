package cookies;


import cookies.recipe.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<Integer, Integer> ingredientsList;

    public Inventory(){
        ingredientsList = new HashMap<>();
    }

    /**
     * sets the quantity of the ingredient int the map to the quantity entered
     * @param ingredient is the item to update
     * @param quantity is the new quantity to put
     * @return false if the item does not exist, true if the item has been successfully updated
     */
    public boolean modifyIngredientsQuantity(Ingredients ingredient, Integer quantity){
        if(ingredientsList.containsKey(ingredient)) {
            ingredientsList.put(ingredient.getId(), quantity);
            return true;
        } else return false;
    }


    /**
     * Sets every ingredients in the ingredientList to the given quantity
     * @param quantity amount to set
     */
    void modifyAllIngredientsQuantity(int quantity) {
        for (Map.Entry<Integer,Integer> entry : this.ingredientsList.entrySet()) {
            this.ingredientsList.put(entry.getKey(), quantity);
        }
    }

    /**
     * tells if an ingredient is available in the quantity asked
     * @param ingredient is the item to check
     * @param quantity is the quantity to check
     * @return true if there is enough of the ingredient, false otherwise
     */
    boolean isIngredientAvailable(Ingredients ingredient, Integer quantity){
        return ingredientsList.containsKey(ingredient.getId()) && (quantity <= ingredientsList.get(ingredient.getId()));
    }

    /**
     * checks if a certain recipe is availabe in the given quantity
     * @param recipe
     * @param quantity
     * @return
     */
//    private boolean isRecipeAvailable(Recipe recipe, int quantity) {
//        if (!isIngredientAvailable(recipe.getDough(), quantity)
//                || !isIngredientAvailable(recipe.getFlavour(), quantity))
//            return false;
//        for (Topping topping : recipe.getToppings()) {
//            if (!isIngredientAvailable(topping, quantity))
//                return false;
//        }
//        return true;
//    }

    /**
     * checks if all recipes are available with the actual stocks
     * @param recipes is a map with a Recipe as the key and an Integer as the quantity
     * @return true if all recipes are available and false if at least one of the recipes is not available
     */
//    boolean areRecipesAvailable(Map<Recipe, Integer> recipes) {
//        for (Map.Entry<Recipe,Integer> entry : recipes.entrySet()) {
//            if (!isRecipeAvailable(entry.getKey(), entry.getValue()))
//                return false;
//        }
//        return true;
//    }

    /**
     * updates the old stock value to the new one if it is possible
     * @param ingredient is the item to update
     * @param quantity is the quantity to subtract to the old one
     * @return the new value; if the old quantity is too small, -1 is returned
     */
    int updateItemQuantity(Ingredients ingredient, Integer quantity) {
        if (this.isIngredientAvailable(ingredient, quantity)){
            Integer oldQuantity = ingredientsList.get(ingredient.getId());
            ingredientsList.put(ingredient.getId(), oldQuantity-quantity);
            return ingredientsList.get(ingredient.getId());
        } else return -1;
    }

    /**
     * updates the quantity in the stocks of each ingredient used in the
     * recipe for a certain amount equal to the quantity given
     * @param recipe is the cookie to get the ingredients from
     * @param quantity is the multiplier to apply to the quantity of
     *                 ingredient to remove from the stocks
     */
//    void updateRecipeQuantity(Recipe recipe, int quantity) {
//        if (isRecipeAvailable(recipe, quantity)) {
//            updateItemQuantity(recipe.getDough(), quantity);
//            updateItemQuantity(recipe.getFlavour(), quantity);
//            for (Topping topping : recipe.getToppings())
//                updateItemQuantity(topping, quantity);
//        }
//
//    }

    /**
     * updates the stocks after using the recipes given
     * @param recipes is the Map of Recipe (key) and quantity (value - Integer) which
     *                is to remove from the stocks
     */
//    void updateAllQuantities(Map<Recipe, Integer> recipes) {
//        if (areRecipesAvailable(recipes)) {
//            for (Map.Entry<Recipe,Integer> entry : recipes.entrySet()) {
//                updateRecipeQuantity(entry.getKey(), entry.getValue());
//            }
//        }
//    }

    /**
     * updates the list of ingredients available by removing an
     * ingredient removed from the CookieFactory
     * @param ingredient is the ingredient to remove
     */
    public void updateRemoveIngredient(Ingredients ingredient) {
        ingredientsList.remove(ingredient.getId());
    }

    /**
     * updates the list of ingredients available by adding an ingredient
     * added to the CookieFactory
     * @param ingredient is the ingredient to add
     */
    public void updateAddIngredient(Ingredients ingredient) {
        ingredientsList.put(ingredient.getId(),0);
    }


//    public void updateAddAllIngredients(List<Dough> doughs, List<Flavour> flavours, List<Topping> toppings) {
//        for(Dough dough : doughs) {
//            ingredientsList.put(dough.getId(), 0);
//        }
//        for(Flavour flavour : flavours) {
//            ingredientsList.put(flavour.getId(), 0);
//        }
//        for(Topping topping : toppings) {
//            ingredientsList.put(topping.getId(), 0);
//        }
//    }
}
