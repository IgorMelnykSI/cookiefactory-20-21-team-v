import cookies.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;
import cookies.manager.StoreManager;

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
        store1 = new Store("store1","address1","8:30","19:00",0.2);
        store2 = new Store("store2","address2","8:00","18:00",0.15);
    }

    @Test
    public void setTax(){
        store1.setTax(0.18);
        assertEquals(store1.getTax(),0.18,0.01);
    }
    @Test
    public void getHour(){
        assertEquals(store1.getOpenTime(),"8:30");
        assertEquals(store2.getCloseTime(),"18:00");
    }
    @Test
    public void setHour(){
        store2.setOpenTime("6:00");
        assertEquals(store2.getOpenTime(),"6:00");
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
}
