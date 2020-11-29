package cucumberTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import cookies.recipe.Recipe;
import io.cucumber.java8.En;


import cookies.CookieFactory;
import cookies.recipe.*;

import java.util.ArrayList;

public class BrandManagerStepdefs implements En {

    Recipe recipe;
    CookieFactory brandManager;

    public BrandManagerStepdefs(){ // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("A brand manager",
                ()->{
                    brandManager = new CookieFactory();
                });
        When("^Jason wants to add a new recipe, whose name is \"([^\"]*)\", dough is \"([^\"]*)\", flavour is \"([^\"]*)\", topping is \"([^\"]*)\", mix is \"([^\"]*)\", cooking is \"([^\"]*)\"$",
                (String name, String price, String dough, String flavour, String topping, String mix, String cooking) ->
                {
                    recipe = new Recipe(name);
                    recipe.setDough(new Dough(dough,2.0));
                    recipe.setFlavour(new Flavour(flavour,0.1));
                    ArrayList<Topping> toppings1 = new ArrayList<>();
                    toppings1.add(new Topping(topping,0.2));
                    recipe.setToppings(toppings1);
                    recipe.setMix(new Mix(mix,0.2));
                    recipe.setCooking(new Cooking(cooking,0.3));
                    recipe.calculatePrice();
                    brandManager.addRecipe(recipe);
        });
        Then("check the recipe has been added",
                () -> {
                    assertEquals(brandManager.getRecipesList().size(),3);
                });

    }
}
