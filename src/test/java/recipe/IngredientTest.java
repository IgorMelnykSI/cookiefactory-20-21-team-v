package recipe;


import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private List<Ingredient> ingredients;
    ToppingCreator toppingCreator;
    FlavourCreator flavourCreator;
    DoughCreator doughCreator;

    @BeforeEach
    public void init() {
        toppingCreator = new ToppingCreator();
        flavourCreator = new FlavourCreator();
        doughCreator = new DoughCreator();
    }

}
