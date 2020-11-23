package recipe;

import cookies.recipe.Dough;
import cookies.recipe.DoughCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoughTest {
    Dough dough;
    DoughCreator doughCreator;

    @BeforeEach
    public void init() {
        dough=new Dough("Plain",2.0);
        doughCreator = new DoughCreator();
    }


    @Test
    void getType() {
        assertEquals("Plain",dough.getType());
    }

    @Test
    void setType() {
        Dough chocolateDough = this.doughCreator.createIngredient("Chocolate", 2);
        assertTrue("Chocolate".equals(chocolateDough.getType()));
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