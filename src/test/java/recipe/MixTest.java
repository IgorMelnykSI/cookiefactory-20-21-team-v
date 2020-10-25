package recipe;

import cookies.recipe.Mix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MixTest {
    Mix mixed=new Mix("Mixed");

    @Test
    void getType() {
        assertEquals("Mixed",mixed.getType());
    }

    @Test
    void setType() {
        mixed.setType("Topped");
        assertEquals("Topped",mixed.getType());
    }
}