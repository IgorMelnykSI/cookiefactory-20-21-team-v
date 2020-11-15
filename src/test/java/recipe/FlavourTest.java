package recipe;

import cookies.recipe.Flavour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlavourTest {
    Flavour flavour=new Flavour("Cinnamon",0.1);

    @Test
    void getType() {
        assertEquals("Cinnamon",flavour.getType());
    }

    @Test
    void setType() {
        flavour.setType("Chili");
        assertEquals("Chili",flavour.getType());
    }

    @Test
    void getPrice(){
        assertTrue(flavour.getPrice()==0.1);
    }
}