package recipe;

import cookies.recipe.Dough;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoughTest {
    Dough dough=new Dough("Plain",2.0);

    @Test
    void getType() {
        assertEquals("Plain",dough.getType());
    }

    @Test
    void setType() {
        dough.setType("Chocolate");
        assertEquals("Chocolate",dough.getType());
    }

    @Test
    void setPrice(){
        dough.setPrice(2.2);
        assertEquals(2.2,dough.getPrice());
    }

    @Test
    void getPrice(){
        assertEquals(2.0,dough.getPrice());
    }

}