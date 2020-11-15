package recipe;

import org.junit.jupiter.api.Test;

import cookies.recipe.Topping;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    Topping aa=new Topping("White chocolate");

    @Test
    void getType() {
        assertTrue(aa.getType()=="White chocolate");
    }

    @Test
    void setType(){
        aa.setType("Milk chocolate");
        assertTrue(aa.getType()=="Milk chocolate");
    }

    @Test
    void setPrice(){
        aa.setPrice();
        assertEquals(0.2,aa.getPrice());
    }

    @Test
    void getPrice(){
        aa.setPrice();
        assertEquals(0.2,aa.getPrice());
    }
}