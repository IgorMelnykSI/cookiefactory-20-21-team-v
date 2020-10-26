package cucumberTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import cookies.manager.BrandManager;
import cookies.recipe.*;
import io.cucumber.java8.En;

public class BrandManagerStepdefs implements En {

    Recipe recipe;
    BrandManager brandManager;

    public BrandManagerStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("A brand manager name {string}",
                (String name)->{
                    brandManager = new BrandManager(name);
                });
        When("Jason wants to add a new recipe, whose name is {string}, price is {string}, dough is {string}, flavour is {string}, topping is {string}, mix is {string}, cooking is {string}",
                (String name, String price, String dough, String flavour, String topping, String mix, String cooking) ->
                {
                    double val = Double.valueOf(price);
                    recipe = new Recipe(name,val);
                    recipe.setDough(new Dough(dough));
                    recipe.setFlavour(new Flavour(flavour));
                    Topping[] toppings = new Topping[3];
                    toppings[0] = new Topping(topping);
                    recipe.setToppings(toppings);
                    recipe.setMix(new Mix(mix));
                    recipe.setCooking(new Cooking(cooking));
                    brandManager.addRecipe(recipe);
                });
        Then("check the recipe has been added",
                () -> {
                    assertEquals(brandManager.getFactory().getRecipesList().size(),3);
                });
    }
}
