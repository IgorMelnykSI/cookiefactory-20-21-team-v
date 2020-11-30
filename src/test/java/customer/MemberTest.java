package customer;

import cookies.CookieFactory;
import cookies.Store;
import cookies.orderState.MyException;
import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;
import cookies.customer.Member;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MemberTest {
    private Member member1;
    private Member member2;
    private Map<Recipe,Integer> mp;
    private Store store;
    private Date date;
    private int way;
    private String home;


    @BeforeEach
    public void init(){

        member1 = new Member("testLu");
        member2 = new Member("trialYao");
        Recipe[] r = new Recipe[2];
        //r[0] = new Recipe("cookie1");//1.5
        //r[0].setPrice(3.0);
        //r[0] = new Recipe("cookie1",cook1,dough1,flavour1,mix1,toppings1);//7
        //r[1] = new Recipe("cookie2");//2
        //r[1].setPrice(2.5);
        //r[1] = new Recipe("cookie2",cook2,dough2,flavour2,mix2,toppings2);//12

        CookieFactory factory=new CookieFactory();
        r[0]=factory.getRecipesList().get(0);
        r[0].calculatePrice();
        r[1]=factory.getRecipesList().get(1);
        r[1].calculatePrice();
        mp = new HashMap<>();
        mp.put(r[0],10);
        mp.put(r[1],20);
        date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR,2020);
        gc.set(Calendar.MONTH, 11);
        gc.set(Calendar.DAY_OF_MONTH, 2);
        date = gc.getTime();
        way=1;
        home="polytech nice sophia";
        store = new Store("store1","Antibes","8:00","16:00",0.15);
        store.initIngre(30);

    }

    @Test
    public void registerLoyal() {
        member1.registerLoyal();

        assertTrue(member1.isLoyal());
        assertFalse(member2.isLoyal());
    }

    @Test
    void saveOrderInHistory() throws MyException, ParseException {
        member1.registerLoyal();
        Order order = member1.creatNoDiscountOrder(mp,way,date,store,home);

        assertFalse(member1.hasDiscount());
        member1.saveOrderInHistory(order);
        assertTrue(member1.hasDiscount());
        assertEquals(member1.getNumCookiesOrdered(), 30);
    }

    @Test
    public void applyLoyaltyDiscount() throws MyException, ParseException {
        member1.registerLoyal();
        member1.creatDiscountOrder(mp,way,date,store,home);
        assertEquals(member1.applyLoyaltyDiscount(),0.1,0.01);
        assertEquals(member2.applyLoyaltyDiscount(),0,0.01);
    }

    @Test
    public void creatDiscountOrder() throws MyException, ParseException {
        member1.registerLoyal();
        Order order1 = member1.creatDiscountOrder(mp,way,date,store,home);
        assertEquals(order1.getPrice(),94,0.01);

        Order order2 = member1.creatDiscountOrder(mp,way,date,store,home);
        assertEquals(member1.applyLoyaltyDiscount(),0.1,0.01);
        assertEquals(order2.getPrice(),84.6,0.01);
    }

    @Test
    public void getId() {
        assertEquals(member1.getId() + 1, member2.getId());
        assertTrue(member2.getId() > 0);
    }

    @Test
    public void createPrivateDiscountOrder() throws MyException, ParseException {
        mp.clear();
        member1.registerLoyal();
        member1.createPrivateRecipe("myrecipe1","Crunchy","Peanut butter","Vanilla","Mixed","M&M’s™ and Reese’s buttercup");
        Recipe myRecipe=member1.getPrivateRecipes().get(0);
        mp.put(myRecipe,30);
        Order od = member1.createPrivateDiscountOrder(mp,way, date,store,home);
        member1.saveOrderInHistory(od);
        od.caculateDiscountPrice(member1.applyLoyaltyDiscount());
        assertEquals(128.25,od.getPrice(),0.01);

    }

}
