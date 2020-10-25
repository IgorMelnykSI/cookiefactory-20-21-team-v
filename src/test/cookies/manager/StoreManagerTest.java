package cookies.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

class StoreTest {
    private StoreManager s1;
    private StoreManager s2;

    @BeforeEach
    public void init(){
        s1=new StoreManager("store1","address1",10,1);
        s2 = new StoreManager("store2","address2",50,1);
    }

    @Test
    public void setTax(){
        s1.setTax(20);
        assertEquals(s1.getTax(),20,0.01);
    }
    @Test
    public void getHour(){
        assertEquals(s1.getOpenHour(4),"8:00-16:30");
        assertEquals(s2.getOpenHour(10),"wrong day please try again");
    }
    @Test
    public void setHour(){
        s2.setOpenHour(0,"6:00-17:00");
        assertEquals(s2.getOpenHour(0),"6:00-17:00");
    }
}
