package recipe;

import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    Recipe recipe1;//5.5
    Cooking crunchy;
    Flavour vanilla;
    Dough peabut;
    Mix mixed;
    Topping mm;
    Topping reese;
    Topping[] tops1;
    Topping[] tops2;

    @BeforeEach
    public void init(){
        recipe1=new Recipe("recipe1");//5.5
        crunchy=new Cooking("Crunchy");
        vanilla=new Flavour("Vanilla");
        peabut=new Dough("Peanut butter");
        mixed=new Mix("Mixed");
        mm=new Topping("M&M’s™");
        reese=new Topping("Reese’s buttercup");
        tops1=new Topping[]{mm,reese};
        tops2=new Topping[]{reese};
    }

    @Test
    void getName() {
        assertTrue(recipe1.getName()=="recipe1");
    }

    @Test
    void getPrice() {
        assertEquals(recipe1.getPrice(),0);
        recipe1.setCooking(crunchy);
        recipe1.setFlavour(vanilla);
        recipe1.setDough(peabut);
        recipe1.setMix(mixed);
        recipe1.setToppings(tops1);
        recipe1.calculatePrice();
        assertEquals(3.8,recipe1.getPrice());
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
    void compareRecipe() {
        recipe1.setCooking(crunchy);
        recipe1.setFlavour(vanilla);
        recipe1.setDough(peabut);
        recipe1.setMix(mixed);
        recipe1.setToppings(tops1);

        Recipe recipe2=new Recipe("recipe2");
        recipe2.setCooking(crunchy);
        recipe2.setFlavour(vanilla);
        recipe2.setDough(peabut);
        recipe2.setMix(mixed);
        recipe2.setToppings(tops1);

        assertTrue(recipe1.compareRecipe(recipe2));
    }

    @Test
    void setPrice() {
        recipe1.setCooking(crunchy);
        recipe1.setFlavour(vanilla);
        recipe1.setDough(peabut);
        recipe1.setMix(mixed);
        recipe1.setToppings(tops1);
        recipe1.calculatePrice();
        assertEquals(3.8,recipe1.getPrice());

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
        assertTrue(crunchy.getType().equals(recipe1.getCooking().getType()));
    }

    @Test
    void setFlavour() {
        recipe1.setFlavour(vanilla);
        assertTrue(vanilla.getType().equals(recipe1.getFlavour().getType()));
    }

    @Test
    void setDough() {
        recipe1.setDough(peabut);
        assertTrue(peabut.getType().equals(recipe1.getDough().getType()));
    }

    @Test
    void setMix() {
        recipe1.setMix(mixed);
        assertTrue(mixed.getType().equals(recipe1.getMix().getType()));
    }

    @Test
    void setToppings() {
        recipe1.setToppings(tops1);
        assertNotEquals(tops2,recipe1.getToppings());
        assertEquals(tops1,recipe1.getToppings());
    }
}