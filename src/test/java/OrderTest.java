
import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.recipe.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Recipe recipe;
    CookieItem item;
    Order order;

    @BeforeEach
    public void init(){
        recipe=new Recipe("recipe1");
        item=new CookieItem(3,recipe);
        order =new Order();
        Store store1=new Store("store1","address1",8,30,19,0,0.2);

    }


    @Test
    void setPickUpDate() {
        Date date=new Date();
        order.setPickUpDate(date);
        assertEquals(order.getPickUpDate(),date);
    }

    @Test
    void setPickUpStore() {
        Store store=new Store("store1","address1",8,30,19,0,0.2);
        order.setPickUpStore(store);
        assertEquals(order.getPickUpStore(),store);
    }

    @Test
    void addCookieItem() {
        assertEquals(order.getCookieItems().size(),0);
        order.addCookieItem(item);
        assertEquals(order.getCookieItems().size(),1);
    }

    @Test
    void caculatePrice() {
        assertEquals(order.getPrice(),0);
        order.addCookieItem(item);
        item.setPrice(7.5);
        order.caculatePrice();
        assertEquals(order.getPrice(),7.5);
    }

    @Test
    void caculateDiscountPrice() {
        order.addCookieItem(item);
        item.setPrice(10);
        order.caculatePrice();
        order.caculateDiscountPrice(0.1);
        assertEquals(order.getPrice(),9.0);
    }

    @Test
    void setDeliveryAddress(){
        order.setDeliveryAddress("Villa nador");
        assertEquals("Villa nador",order.getDeliveryAddress());
    }

    @Test
    void chooseTheWayToPick(){
        assertEquals("pickUp",order.chooseTheWayToPick(1));
        assertEquals("homeDelivery",order.chooseTheWayToPick(2));
        assertEquals(null,order.chooseTheWayToPick(3));
    }

}