package recipe;

import cookies.recipe.Flavour;
import cookies.recipe.FlavourCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlavourTest {
    Flavour flavour;
    FlavourCreator flavourCreator;

    @BeforeEach
    public void init() {
        flavour=new Flavour("Cinnamon",0.1);
        flavourCreator = new FlavourCreator();
    }

    @Test
    void getType() {
        assertEquals("Cinnamon",flavour.getType());
    }

    @Test
    void setType() {
        Flavour chili = this.flavourCreator.createIngredient("Chili", 2);
        assertTrue("Chili".equals(chili.getType()));
    }

    @Test
    void getPrice(){
        assertTrue(flavour.getPrice()==0.1);
    }
}