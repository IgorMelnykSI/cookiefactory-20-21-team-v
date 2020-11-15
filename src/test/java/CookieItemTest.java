

import cookies.CookieItem;
import cookies.recipe.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieItemTest {
    Recipe[] r;
    CookieItem[] ck;
    @BeforeEach
    void init(){

        r = new Recipe[2];
        r[0] = new Recipe("cookie1",1.5);
        r[1] = new Recipe("cookie2",2);
        ck = new CookieItem[2];
        ck[0] = new CookieItem(10,r[0]);
        ck[1] = new CookieItem(5,r[1]);
    }
    @Test
    void getPrice() {
        assertEquals(15,ck[0].getPrice());
        assertEquals(10,ck[1].getPrice());
    }

    @Test
    void getQuantity() {
        assertEquals(10,ck[0].getQuantity());
        assertEquals(5,ck[1].getQuantity());
    }

    @Test
    void getRecipeName() {
        assertEquals("cookie1",ck[0].getRecipeName());
        assertEquals("cookie2",ck[1].getRecipeName());
    }


    @Test
    void setQuantity() {
        ck[0].setQuantity(15);
        assertEquals(15,ck[0].getQuantity());
    }

    @Test
    void setRecipeName() {
        ck[0].setRecipeName("cookie3");
        assertEquals("cookie3",ck[0].getRecipeName());
    }

    @Test
    void changeToBestOf(){
        ck[0].changeToBestOf();
        assertEquals(ck[0].getPrice(),13.5);
    }
}