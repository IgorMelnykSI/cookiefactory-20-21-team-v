package recipe;

import org.junit.jupiter.api.Test;

import cookies.recipe.Topping;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    Topping topping=new Topping("White chocolate",0.2);

    @Test
    void getType() {
        assertTrue(topping.getType()=="White chocolate");
    }

    @Test
    void setType(){
        topping.setType("Milk chocolate");
        assertTrue(topping.getType()=="Milk chocolate");
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