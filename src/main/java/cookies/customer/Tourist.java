package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.recipe.Recipe;


import java.util.Date;
import java.util.Map;

public class Tourist {

    public Order creatOrder(Map<Recipe, Integer> mp, Date date, Store store){
        Order order = new Order();
        for(Recipe recipe : mp.keySet()){
            order.addCookieItem(new CookieItem(mp.get(recipe),recipe));
        }
        order.setPickUpDate(date);
        order.caculatePrice(0.0);
        order.setPickUpStore(store);
        return order;
    }
}
