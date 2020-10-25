package cookies.manager;

import cookies.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreManagerTest {
    Store store;
    StoreManager storeManager;
    @BeforeEach
    void init(){
        store = new Store("store1","Biot","8:00","16:00",0.15);
        storeManager = new StoreManager("Biot",store);
    }


    @Test
    void changeOpenTime() {
        storeManager.changeOpenTime("8:30");
        assertEquals("8:30",store.getOpenTime());
    }

    @Test
    void changeCloseTime() {
        storeManager.changeCloseTime("16:30");
        assertEquals("16:30",store.getCloseTime());
    }
}