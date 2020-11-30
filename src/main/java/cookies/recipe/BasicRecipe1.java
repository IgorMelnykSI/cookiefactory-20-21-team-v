package cookies.recipe;

import java.util.ArrayList;

public class BasicRecipe1 extends BasicRecipeBuilder {
    @Override
    public void buildCooking() {
        recipe.setCooking(factory.getCookingList().get(0));
    }

    @Override
    public void buildDough() {
        recipe.setDough(factory.getDoughList().get(0));
    }

    @Override
    public void buildFlavour() {
        recipe.setFlavour(factory.getFlavourList().get(0));
    }

    @Override
    public void buildMix() {
        recipe.setMix(factory.getMixList().get(0));
    }

    @Override
    public void buildTopping() {
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(factory.getToppingList().get(0));
        recipe.setToppings(toppings);
    }

    @Override
    public void buildName() {
        recipe.setName("recipe1");
    }
}
