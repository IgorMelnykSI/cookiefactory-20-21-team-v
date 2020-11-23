import cookies.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
}
