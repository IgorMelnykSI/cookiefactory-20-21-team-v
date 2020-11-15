package recipe;

import cookies.recipe.Cooking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookingTest {
    Cooking cooking=new Cooking("Crunchy",0.3);

    @Test
    void getType() {
        assertEquals("Crunchy",cooking.getType());
    }

    @Test
    void setType() {
        cooking.setType("Chewy");
        assertEquals("Chewy",cooking.getType());
    }
    @Test
    void setPrice(){
        cooking.setPrice(0.2);
        assertEquals(0.2,cooking.getPrice());
    }

    @Test
    void getPrice(){
        assertEquals(0.3,cooking.getPrice());
    }
}