package cucumberTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cookies.manager.BrandManager;
import cookies.recipe.Recipe;
import io.cucumber.java8.En;


import cookies.CookieFactory;
import cookies.recipe.*;

import java.util.ArrayList;

public class BrandManagerStepdefs implements En {

    Recipe recipe;
    BrandManager brandManager;


    public BrandManagerStepdefs(){ // implementation des steps dans le constructeur (aussi possible dans des méthodes)

            Given("^A brand manager named \"([^\"]*)\"$",

                (String name)->{
                    brandManager = new BrandManager(name);
                });
        When("^Jason wants to add a new recipe, whose name is \"([^\"]*)\", dough is \"([^\"]*)\", flavour is \"([^\"]*)\", topping is \"([^\"]*)\", mix is \"([^\"]*)\", cooking is \"([^\"]*)\"$",
                (String name, String dough, String flavour, String topping, String mix, String cooking) ->
                {
                    ArrayList<Topping> toppings1 = new ArrayList<>();
                    toppings1.add(new Topping(topping,0.2));
                    recipe = new Recipe(name,brandManager.getFactory().getCooking(cooking),brandManager.getFactory().getDough(dough),brandManager.getFactory().getFlavour(flavour),brandManager.getFactory().getMix(mix),toppings1);
                    recipe.calculatePrice();
                    brandManager.getFactory().addRecipe(recipe);
        });
        Then("check the recipe has been added",
                () -> {
                    assertEquals(brandManager.getFactory().getRecipesList().size(),3);
                });

    }
}
