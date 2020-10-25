package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.recipe.Recipe;


import java.util.Date;
import java.util.Map;

public class Tourist {

    public Order creatOrder(Map<Recipe, Integer> mp, Date date){
        Order order = new Order();
        for(Recipe recipe : mp.keySet()){
            order.addCookieItem(new CookieItem(mp.get(recipe),recipe));
        }
        order.setPickUpDate(date);
        order.caculatePrice(0.0);
        System.out.println(order.getOrderID()); //he use the ID to pick his cookies
        return order;
    }
}
