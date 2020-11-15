package customer;

import cookies.Order;
import cookies.Store;
import cookies.customer.MyException;
import cookies.customer.Tourist;
import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.CookieFactory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TouristTest {
    Tourist t;
    Map<Recipe,Integer> mp;
    Store store, store1;
    Date date;
    int way1;
    int way2;
    String home;
    @BeforeEach
    void init(){
        t = new Tourist();

        Recipe[] r = new Recipe[2];
        r[0] = new Recipe("cookie1");//1
        r[0].setPrice(3.0);
        r[1] = new Recipe("cookie2");//2
        r[1].setPrice(2.5);
        mp = new HashMap<>();
        mp.put(r[0],10);
        mp.put(r[1],15);
        date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR,2020);//设置年
        gc.set(Calendar.MONTH, 10);//这里0是1月..以此向后推
        gc.set(Calendar.DAY_OF_MONTH, 2);//设置天
        date = gc.getTime();
        way1=1;
        way2=2;
        home="polytech nice sophia";
        store = new Store("store1","Antibes",8,0,16,0,0.15);
        store1 = new Store("store2","Antibes",7,0,16,0,0.15);
    }
    @Test
    void creatOrder() throws MyException {
        Order od = t.creatNoDiscountOrder(mp,way1, date,store,home);
        assertEquals(null,od.getDeliveryAddress());
        assertEquals(67.5,od.getPrice());
        assertEquals(date.toString(),od.getPickUpDate().toString());
        assertEquals(store,od.getPickUpStore());
        Order order2 =t.creatNoDiscountOrder(mp,way2, date,store,home);
        assertEquals(home,order2.getDeliveryAddress());
    }

//    @Test
//    void changeStore(){
//
//    }

    @Test
    void createPrivateOrder() throws MyException {
        mp.clear();
        Cooking crunchy=new Cooking("Crunchy",0.3);
        Dough peabut=new Dough("Peanut butter",2.5);
        Flavour vanilla=new Flavour("Vanilla",0.1);
        Mix mixed=new Mix("Mixed",0.2);
        Topping mm=new Topping("M&M’s™",0.3);
        Topping reese=new Topping("Reese’s buttercup",0.4);
        Topping[] tops1=new Topping[]{mm,reese};
        Recipe myRecipe=t.createPrivateRecipe(crunchy,peabut,vanilla,mixed,tops1);
        mp.put(myRecipe,15);

        Order od = t.createPrivateOrder(mp,way1, date,store,home);
        assertEquals(71.25,od.getPrice());
        assertEquals(date.toString(),od.getPickUpDate().toString());
        assertEquals(store,od.getPickUpStore());
    }

    @Test
    void addPrivateRecipe(){
        Cooking crunchy=new Cooking("Crunchy",0.3);
        Dough peabut=new Dough("Peanut butter",2.5);
        Flavour vanilla=new Flavour("Vanilla",0.1);
        Mix mixed=new Mix("Mixed",0.2);
        Topping mm=new Topping("M&M’s™",0.3);
        Topping reese=new Topping("Reese’s buttercup",0.4);
        Topping[] tops1=new Topping[]{mm,reese};
        Recipe myRecipe=t.createPrivateRecipe(crunchy,peabut,vanilla,mixed,tops1);
        assertEquals(3.8,myRecipe.getPrice());
    }
}