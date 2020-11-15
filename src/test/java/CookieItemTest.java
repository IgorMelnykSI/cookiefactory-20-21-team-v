

import cookies.CookieItem;
import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieItemTest {
    Recipe[] r;
    CookieItem[] ck;
    @BeforeEach
    void init(){

        r = new Recipe[2];
        r[0] = new Recipe("cookie1");//1.5
        r[1] = new Recipe("cookie2");//2
        r[0].setCooking(new Cooking("Crunchy",0.3));
        r[0].setFlavour(new Flavour("Vanilla",0.1));
        r[0].setDough(new Dough("Peanut butter",2.5));
        r[0].setMix(new Mix("Mixed",0.2));
        Topping mm=new Topping("M&M’s™",0.3);
        Topping[] tops1=new Topping[]{mm};
        r[0].setToppings(tops1);
        ck = new CookieItem[2];
        ck[0] = new CookieItem(10,r[0]);
        ck[1] = new CookieItem(5,r[1]);
    }
    @Test
    void getPrice() {
        r[0].calculatePrice();
        ck[0].calculatePrice();
        assertEquals(34.0,ck[0].getPrice());
        assertEquals(0,ck[1].getPrice());
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
        assertEquals(ck[0].getPrice(),0);
        r[0].calculatePrice();
        ck[0].calculatePrice();
        ck[0].changeToBestOf();
        assertEquals(30.6,ck[0].getPrice());

    }

    @Test
    void calculatePrice(){
        r[0].calculatePrice();
        ck[0].calculatePrice();
        assertEquals(34.0,ck[0].getPrice());
        ck[0].setIsPersonalized();
        ck[0].calculatePrice();
        assertEquals(42.5,ck[0].getPrice());

    }

    @Test
    void setIsPersonalized(){
        ck[0].setIsPersonalized();
        assertAll(
                () -> assertEquals(ck[0].getIsPersonalized(),true),
                () -> assertEquals(ck[1].getIsPersonalized(),false)
        );
    }

    @Test
    void getIsPersonalized(){
        assertAll(
                () -> assertEquals(ck[0].getIsPersonalized(),false),
                () -> assertEquals(ck[1].getIsPersonalized(),false)
        );
        ck[0].setIsPersonalized();
        assertEquals(ck[0].getIsPersonalized(),true);
    }
}