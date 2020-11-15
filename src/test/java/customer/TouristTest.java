package customer;

import cookies.Order;
import cookies.Store;
import cookies.customer.MyException;
import cookies.customer.Tourist;
import cookies.recipe.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TouristTest {
    Tourist t;
    Map<Recipe,Integer> mp;
    Store store, store1;
    Date date;
    int way;
    String home;
    @BeforeEach
    void init(){
        t = new Tourist();
        Recipe[] r = new Recipe[2];
        r[0] = new Recipe("cookie1",1.5);
        r[1] = new Recipe("cookie2",2);
        mp = new HashMap<>();
        mp.put(r[0],10);
        mp.put(r[1],15);
        date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR,2020);//设置年
        gc.set(Calendar.MONTH, 10);//这里0是1月..以此向后推
        gc.set(Calendar.DAY_OF_MONTH, 2);//设置天
        date = gc.getTime();
        way=1;
        home="polytech nice sophia";
        store = new Store("store1","Antibes",8,0,16,0,0.15);
        store1 = new Store("store2","Antibes",7,0,16,0,0.15);
    }
    @Test
    void creatOrder() throws MyException {
        Order od = t.creatNoDiscountOrder(mp,way, date,store,home);
        assertEquals(45,od.getPrice());
        assertEquals(date.toString(),od.getPickUpDate().toString());
        assertEquals(store,od.getPickUpStore());
    }

    @Test
    void changeStore(){

    }
}