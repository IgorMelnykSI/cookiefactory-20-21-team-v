package recipe;

import cookies.recipe.Cooking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookingTest {
    Cooking crunchy=new Cooking("Crunchy");

    @Test
    void getType() {
        assertEquals("Crunchy",crunchy.getType());
    }

    @Test
    void setType() {
        crunchy.setType("Chewy");
        assertEquals("Chewy",crunchy.getType());
    }
    @Test
    void setPrice(){
//        crunchy.setPrice();
        assertEquals(0.3,crunchy.getPrice());
    }

    @Test
    void getPrice(){
        crunchy.setPrice();
        assertEquals(0.3,crunchy.getPrice());
    }
}