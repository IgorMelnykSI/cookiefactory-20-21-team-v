package cookies.manager;

import cookies.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class StoreManagerTest {
    private StoreManager storeManager;
    private Store store1;
    @BeforeEach
    public void init(){
        store1 = new Store("store1","address1","8:30","19:00",0.2);
        storeManager = new StoreManager("Paul",store1);
    }
    @Test
    void changeOpenTime() {
        storeManager.changeOpenTime("9:00");
        assertEquals(store1.getOpenTime(),"9:00");
    }

    @Test
    void changeCloseTime() {
        storeManager.changeCloseTime("18:00");
        assertEquals(store1.getCloseTime(),"18:00");
    }

    @Test
    void changeTax() {
        storeManager.changeTax(0.18);
        assertEquals(store1.getTax(),0.18,0.01);
    }
}