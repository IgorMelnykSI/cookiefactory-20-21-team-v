package recipe;

import cookies.recipe.Dough;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoughTest {
    Dough plain=new Dough("Plain");

    @Test
    void getType() {
        assertEquals("Plain",plain.getType());
    }

    @Test
    void setType() {
        plain.setType("Chocolate");
        assertEquals("Chocolate",plain.getType());
    }

    @Test
    void setPrice(){
        plain.setPrice();
        assertEquals(2.0,plain.getPrice());
    }

    @Test
    void getPrice(){
        plain.setPrice();
        assertEquals(2.0,plain.getPrice());
    }

}