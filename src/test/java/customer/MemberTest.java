package customer;

import cookies.Store;
import cookies.customer.MyException;
import cookies.recipe.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;
import cookies.customer.Member;

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
        r[0] = new Recipe("cookie1",1.5);
        r[1] = new Recipe("cookie2",2);
        mp = new HashMap<>();
        mp.put(r[0],10);
        mp.put(r[1],20);
        date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR,2020);
        gc.set(Calendar.MONTH, 11);
        gc.set(Calendar.DAY_OF_MONTH, 2);
        date = gc.getTime();
        store = new Store("store1","Antibes","8:00","16:00",0.15);
        way=1;
        home="polytech nice sophia";
    }

    @Test
    public void registerLoyal() {
        member1.registerLoyal();

        assertTrue(member1.isLoyal());
        assertFalse(member2.isLoyal());
    }

    @Test
    void saveOrderInHistory() throws MyException {
        member1.registerLoyal();
        Order order = member1.creatNoDiscountOrder(mp,way,date,store,home);

        assertFalse(member1.hasDiscount());
        member1.saveOrderInHistory(order);
        assertTrue(member1.hasDiscount());
        assertEquals(member1.getNumCookiesOrdered(), 30);
    }

    @Test
    public void applyLoyaltyDiscount() throws MyException {
        member1.registerLoyal();
        member1.creatDiscountOrder(mp,way,date,store,home);
        assertEquals(member1.applyLoyaltyDiscount(),0.1,0.01);
        assertEquals(member2.applyLoyaltyDiscount(),0,0.01);
        assertEquals(member1.applyLoyaltyDiscount(),0,0.01);
    }

    @Test
    public void creatDiscountOrder() throws MyException {
        member1.registerLoyal();
        Order order1 = member1.creatDiscountOrder(mp,way,date,store,home);
        assertEquals(order1.getPrice(),55.0,0.01);

        Order order2 = member1.creatDiscountOrder(mp,way,date,store,home);
        assertEquals(member1.applyLoyaltyDiscount(),0.1,0.01);
        assertEquals(order2.getPrice(),49.5,0.01);
    }

    @Test
    public void getId() {
        assertEquals(member1.getId() + 1, member2.getId());
        assertTrue(member2.getId() > 0);
    }
}
