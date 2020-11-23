package recipe;

import cookies.recipe.ToppingCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cookies.recipe.Topping;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    Topping topping;
    ToppingCreator toppingCreator;

    @BeforeEach
    public void init() {
        topping=new Topping("White chocolate",0.2);
        toppingCreator = new ToppingCreator();
    }

    @Test
    void getType() {
        assertTrue(topping.getType()=="White chocolate");
    }

    @Test
    void setType(){
        Topping chocolateTopping = this.toppingCreator.createIngredient("Milk chocolate", 2);
        assertTrue("Milk chocolate".equals(chocolateTopping.getType()));
    }

    @Test
    void setPrice(){
        topping.setPrice(0.25);
        assertEquals(0.25,topping.getPrice());
    }

    @Test
    void getPrice(){
        assertEquals(0.2,topping.getPrice());
    }
}