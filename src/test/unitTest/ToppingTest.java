package unitTest;

import org.junit.jupiter.api.Test;

import cookies.recipe.Topping;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    Topping aa=new Topping("swe");

    @Test
    void getType() {
        assertTrue(aa.getType()=="swe");
    }
}