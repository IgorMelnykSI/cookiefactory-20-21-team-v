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

    @Test
    void checkId() {
        Dough chocolatDough = this.doughCreator.createIngredient("chocolat", 2);

        Flavour chocolatFlavour = this.flavourCreator.createIngredient("chocolat", 3);
        assertEquals(chocolatDough.getId()+1, chocolatFlavour.getId());

        Dough chocolatDough2 = this.doughCreator.createIngredient("chocolat", 2);
        assertEquals(chocolatDough.getId()+2, chocolatDough2.getId());
    }
}
