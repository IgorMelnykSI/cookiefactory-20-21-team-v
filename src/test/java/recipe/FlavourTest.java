package recipe;

import cookies.recipe.Flavour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlavourTest {
    Flavour cinnamon=new Flavour("Cinnamon");

    @Test
    void getType() {
        assertEquals("Cinnamon",cinnamon.getType());
    }

    @Test
    void setType() {
        cinnamon.setType("Chili");
        assertEquals("Chili",cinnamon.getType());
    }

    @Test
    void getPrice(){
        assertTrue(cinnamon.getPrice()==0.1);
    }
}