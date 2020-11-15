package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.recipe.Recipe;


import java.util.Date;
import java.util.Map;
import java.util.Scanner;



public class Tourist {


    public Order creatNoDiscountOrder(Map<Recipe, Integer> mp,int way, Date date, Store store,String deliveryAddress) throws MyException {
        Order order = new Order();
        String wayToTake=order.chooseTheWayToPick(way);
         if (wayToTake=="pickUp"){
             order.setPickUpDate(date);
             order.setPickUpStore(store);
         }else if(wayToTake=="homeDelivery"){
             order.setDeliveryAddress(deliveryAddress);
         }else {
             throw new MyException("非法配送方式, 请输入序号选择配送方式:" +
                     "\n1. Pick up" +
                     "\n2. Home delivery");
         }
        if (order.chooseTheWayToPick(way)=="pickUp"){
            order.setPickUpDate(date);
            order.setPickUpStore(store);
        }else if(order.chooseTheWayToPick(way)=="homeDelivery"){
            order.setDeliveryAddress(deliveryAddress);
        }else {
            throw new MyException("非法配送方式, 请输入序号选择配送方式:" +
                    "\n1. Pick up" +
                    "\n2. Home delivery");
        }

        for(Recipe recipe : mp.keySet()){
            order.addCookieItem(new CookieItem(mp.get(recipe),recipe));
        }
        order.caculatePrice();
        return order;
    }


}