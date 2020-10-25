package unitTest;

import cookies.recipe.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe recipe1=new Recipe("recipe1",5.5);
    Cooking crunchy=new Cooking("Crunchy");
    Flavour vanilla=new Flavour("Vanilla");
    Dough peabut=new Dough("Peanut butter");
    Mix mixed=new Mix("Mixed");
    Topping mm=new Topping("M&M’s™");
    Topping reese=new Topping("Reese’s buttercup");
    Topping[] tops1=new Topping[]{mm,reese};
    Topping[] tops2=new Topping[]{reese};

    @Test
    void getName() {
        assertTrue(recipe1.getName()=="recipe1");
    }

    @Test
    void getPrice() {
        assertTrue(recipe1.getPrice()==5.5);
    }


    @Test
    void setName() {
        recipe1.setName("choco");
        assertAll(
                ()->assertTrue(recipe1.getName()!="recipe1"),
                ()->assertEquals("choco",recipe1.getName())
        );
    }

    @Test
    void setPrice() {
        recipe1.setPrice(7.82);
        assertAll(
                ()->assertFalse(recipe1.getPrice()==5.5),
                ()->assertEquals(7.82,recipe1.getPrice())
        );
    }

    @Test
    void testIngres(){
        assertAll(
                ()->assertTrue(recipe1.getCooking()==null),
                ()->assertTrue(recipe1.getDough()==null),
                ()->assertTrue(recipe1.getFlavour()==null),
                ()->assertTrue(recipe1.getMix()==null),
                ()->assertTrue(recipe1.getToppings()==null)
        );
    }

    @Test
    void setCooking() {
        recipe1.setCooking(crunchy);
        assertEquals(crunchy,recipe1.getCooking());
    }

    @Test
    void setFlavour() {
        recipe1.setFlavour(vanilla);
        assertEquals(vanilla,recipe1.getFlavour());
    }

    @Test
    void setDough() {
        recipe1.setDough(peabut);
        assertEquals(peabut,recipe1.getDough());
    }

    @Test
    void setMix() {
        recipe1.setMix(mixed);
        assertEquals(mixed,recipe1.getMix());
    }

    @Test
    void setToppings() {
        recipe1.setToppings(tops1);
        assertNotEquals(tops2,recipe1.getToppings());
        assertEquals(tops1,recipe1.getToppings());
    }
}