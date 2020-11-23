package cookies.recipe;

import java.util.List;

public class PrivateRecipe extends Recipe{

    private double price;
    private Dough dough;
    private Flavour flavour;
    private Mix mix;
    private Cooking cooking;
    private List<Topping> toppings;

    public PrivateRecipe(String name, Cooking cook, Dough dough, Flavour flavour, Mix mix, List<Topping> toppings) {
        super(name, cook, dough, flavour, mix, toppings);
    }
}
