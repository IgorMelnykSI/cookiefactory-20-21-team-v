package recipe;

import cookies.recipe.Mix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MixTest {
    Mix mix=new Mix("Mixed",0.2);

    @Test
    void getType() {
        assertEquals("Mixed",mix.getType());
    }

    @Test
    void setType() {
        mix.setType("Topped");
        assertEquals("Topped",mix.getType());
    }

    @Test
    void setPrice(){
        mix.setPrice(0.3);
        assertEquals(0.3,mix.getPrice());
    }

    @Test
    void getPrice(){
        assertEquals(0.2,mix.getPrice());
    }
}