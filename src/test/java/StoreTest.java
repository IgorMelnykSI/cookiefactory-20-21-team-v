import cookies.CookieFactory;
import cookies.CookieItem;
import cookies.Store;
import cookies.order.MyException;
import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class StoreTest {
    CookieFactory cookieFactory;
    private Store store1;
    private Store store2;
    Order order;
    Map<Recipe,Integer> mp;
    Cooking cook1=new Cooking("cook1",1);
    Cooking cook2=new Cooking("cook2",2);
    Dough dough1=new Dough("dough1",1);
    Dough dough2=new Dough("dough2",2);
    Flavour flavour1=new Flavour("flavour1",1);
    Flavour flavour2=new Flavour("flavour2",2);
    Mix mix1=new Mix("mix1",1);
    Mix mix2=new Mix("mix2",2);
    Topping top1=new Topping("top1",1);
    Topping top2=new Topping("top2",2);
    Topping top3=new Topping("top3",3);
    List<Topping> toppings1=new ArrayList<>();
    List<Topping> toppings2=new ArrayList<>();

    @BeforeEach
    public void init(){
        toppings1.add(top1);
        toppings1.add(top2);
        toppings2.add(top1);
        toppings2.add(top3);
        cookieFactory = new CookieFactory();
        store1 = new Store("store1","address1","8","30","19","0",0.2);
        store2 = new Store("store2","address2","8","0","18","0",0.15);
        Recipe[] r = new Recipe[2];
        //r[0] = new Recipe("cookie1");//1
        //r[0].setPrice(3.0);
        //r[1] = new Recipe("cookie2");//2
        //r[1].setPrice(2.5);
        r[0] = new Recipe("cookie1",cook1,dough1,flavour1,mix1,toppings1);//7
        r[1] = new Recipe("cookie2",cook2,dough2,flavour2,mix2,toppings2);//12
        mp = new HashMap<>();
        mp.put(r[0],10);
        mp.put(r[1],15);
    }

    @Test
    public void setTax(){
        store1.setTax(0.18);
        assertEquals(store1.getTax(),0.18,0.01);
    }


    @Test
    public void deleteExpiredOrder(){
        order = new Order();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR,2020);
        gc.set(Calendar.MONTH, 1);
        gc.set(Calendar.DAY_OF_MONTH, 2);
        Date date = gc.getTime();
        order.setPickUpDate(date);

        store1.saveOrder(order);
        assertEquals(1,store1.getHistoryOrders().size());
        store1.deleteExpiredOrder();
        assertEquals(0,store1.getHistoryOrders().size());
    }

    @Test
    public void setPosition(){
        double[] position = {1.1,2.2};
        store1.setPosition(position[0],position[1]);
        assertEquals(position[0], store1.getPosition()[0], 0.0);
        assertEquals(position[1], store1.getPosition()[1], 0.0);
    }

    @Test
    public void isBusy(){
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(2020,Calendar.DECEMBER, 1,18,30);
        Order[] order = new Order[30];
        Date date = gc.getTime();
        gc.set(2020,Calendar.DECEMBER, 1,19,30);
        Date date1 = gc.getTime();

        for(int i = 0; i < 5 ; i++){
            order[i] = new Order();
            order[i].setPickUpStore(store1);
            order[i].setPickUpDate(date);
            store1.saveOrder(order[i]);
        }
        for(int i = 5; i < 30 ; i++){
            order[i] = new Order();
            order[i].setPickUpStore(store1);
            order[i].setPickUpDate(date1);
            store1.saveOrder(order[i]);
        }
        assertTrue(store1.isBusy(date1));
        assertFalse(store1.isBusy(date));


    }
    @Test
    public void canTakeOrder(){
        Dough plain = new Dough("Plain",2.0);
        Flavour chili = new Flavour("chili",0.1);
        Topping whitechoco = new Topping("White chocolate",0.2);
        List<Topping> toppings = new LinkedList<>();
        toppings.add(whitechoco);
        Mix topped = new Mix("Topped",0.3);
        Cooking chewy = new Cooking("Chewy",0.4);
        Recipe recipe1= new Recipe("recipe1",chewy,plain,chili,topped,toppings);
        Order order1 = new Order();
        CookieItem cookieItem1= new CookieItem(1000,recipe1);
        order1.addCookieItem(cookieItem1);
//        assertEquals(true,store1.checkOrder(order1));
    }

    @Test
    public void modifyAllIngredientsQuantity(){
        cookieFactory.addStore(store1);
        Dough plain = new Dough("Plain",2.0);
        Dough tmp = cookieFactory.getDoughList().get(1);
        assertFalse(store1.isIngredientAvailable(plain,1));
        assertFalse(store1.isIngredientAvailable(tmp,1));

        store1.modifyAllIngredientsQuantity(10);
        assertFalse(store1.isIngredientAvailable(plain,11));
        assertTrue(store1.isIngredientAvailable(tmp,1));

        store1.modifyAllIngredientsQuantity(0);
        assertFalse(store1.isIngredientAvailable(tmp,1));
        assertTrue(store1.isIngredientAvailable(tmp,0));
    }

    @Test
    public void modifyIngredientQuantity(){
        cookieFactory.addStore(store2);
        Dough plain = new Dough("Plain",2.0);
        Dough tmp = cookieFactory.getDoughList().get(1);
        assertFalse(store2.isIngredientAvailable(plain,1));
        assertFalse(store2.isIngredientAvailable(tmp,1));

        assertTrue(store2.modifyIngredientQuantity(tmp,10));
        assertTrue(store2.isIngredientAvailable(tmp,1));

        assertTrue(store2.modifyIngredientQuantity(tmp,0));
        assertFalse(store2.isIngredientAvailable(tmp,1));
        assertTrue(store2.isIngredientAvailable(tmp,0));

        assertTrue(store2.modifyIngredientQuantity(tmp,10));
        assertEquals(0,store2.subtractIngredientQuantity(tmp,10));
        assertEquals(-1,store2.subtractIngredientQuantity(tmp,10));
    }

    @Test
    public void updateIngredient(){
        cookieFactory.addStore(store1);
        Dough plain = new Dough("Plain",2.0);
        Dough tmp = cookieFactory.getDoughList().get(1);
        assertFalse(store1.isIngredientAvailable(plain,1));
        assertFalse(store1.isIngredientAvailable(tmp,1));

        store1.modifyAllIngredientsQuantity(10);
        assertFalse(store1.isIngredientAvailable(plain,11));
        assertTrue(store1.isIngredientAvailable(tmp,1));

        store1.updateAddIngredient(tmp);
        assertFalse(store1.isIngredientAvailable(tmp,1));

        store1.updateAddIngredient(plain);
        assertTrue(store1.modifyIngredientQuantity(plain,10));
    }

    @Test
    public void checkOrder() throws MyException {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(2020,Calendar.DECEMBER, 1,18,30);
        Date date = gc.getTime();
        store1.initIngre(50);
        order = new Order(mp,1,date,store1,"Polytech Nice Sophia");
        assertTrue(store1.checkOrder(order));
    }

}
