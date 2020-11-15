package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.recipe.Recipe;


import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Tourist {

    public Order creatNoDiscountOrder(Map<Recipe, Integer> mp, Date date, Store store){
        Order order = new Order();
        order.setPickUpDate(date);
        order.setPickUpStore(store);
        for(Recipe recipe : mp.keySet()){
            order.addCookieItem(new CookieItem(mp.get(recipe),recipe));
        }
        order.caculatePrice();
        return order;
    }


}
