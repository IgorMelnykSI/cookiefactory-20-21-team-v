import cookies.CookieItem;
import cookies.Store;
import cookies.recipe.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class StoreTest {
    private Store store1;
    private Store store2;
    Order order;

    @BeforeEach
    public void init(){
        store1 = new Store("store1","address1",8,30,19,0,0.2);
        store2 = new Store("store2","address2",8,0,18,0,0.15);
    }

    @Test
    public void setTax(){
        store1.setTax(0.18);
        assertEquals(store1.getTax(),0.18,0.01);
    }
    @Test
    public void getHour(){
        assertEquals(store1.getOpenHour(),8);
        assertEquals(store2.getCloseHour(),18);
    }
    @Test
    public void setHour(){
        store2.setOpenTime(6,0);
        assertEquals(store2.getOpenHour(),6);
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
    public void isBusy() throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("dd-mm-yyyy");
        String dateStringToParse = "08-08-2020";
        String dateStringToParse1 = "09-08-2020";
        Order[] order = new Order[30];
        try {
            Date date = f.parse(dateStringToParse);
            Date date1 = f.parse(dateStringToParse1);
            for(int i = 0; i < 30 ; i++){
                order[i].setPickUpStore(store1);
                order[i].setPickUpDate(date);
            }
            assertTrue(store1.isBusy(date));
            assertFalse(store1.isBusy(date1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }






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
        order1.setPickUpTime(11,0);
//        assertEquals(true,store1.checkOrder(order1));
    }
}
