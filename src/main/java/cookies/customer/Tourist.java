package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.Statistic;
import cookies.Store;
import cookies.recipe.*;



import java.util.Date;
import java.util.Map;
import java.util.Scanner;



public class Tourist {

    private boolean isPrivateCookieItem=false;

    public Order creatNoDiscountOrder(Map<Recipe, Integer> mp,int way, Date date, Store store,String deliveryAddress) throws MyException {
        Order order = new Order();
        String wayToTake=order.chooseTheWayToPick(way);
         if (wayToTake=="pickUp"){
             order.setPickUpDate(date);
             order.setPickUpStore(store);
         }else if(wayToTake=="homeDelivery"){
             order.setPickUpStore(store);//这是为了确定客户选择哪家店下订单
             order.setDeliveryAddress(deliveryAddress);
         }else {
             throw new MyException("非法配送方式, 请输入序号选择配送方式:" +
                     "\n1. Pick up" +
                     "\n2. Home delivery");
         }

        for(Recipe recipe : mp.keySet()){
            CookieItem item=new CookieItem(mp.get(recipe),recipe);
            item.calculatePrice();
            order.addCookieItem(item);
        }
        order.caculatePrice();
        return order;
    }

     public Order createPrivateOrder(Map<Recipe, Integer> mp,int way, Date date, Store store,String deliveryAddress) throws MyException {
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
        if(store.hasProblem()){
            throw new MyException("The store has technical problems, please choose another store\n");
        }
//
        for(Recipe recipe : mp.keySet()){
            CookieItem item=new CookieItem(mp.get(recipe),recipe);
            item.setIsPersonalized();
            item.calculatePrice();
            order.addCookieItem(item);
        }
        order.caculatePrice();
        return order;
    }

    public Recipe createPrivateRecipe(Cooking cook,Dough dough,Flavour flavour,Mix mix,Topping[]toppings){
        Recipe myRecipe=new Recipe("privateRecipe");
        myRecipe.setCooking(cook);
        myRecipe.setDough(dough);
        myRecipe.setFlavour(flavour);
        myRecipe.setMix(mix);
        myRecipe.setToppings(toppings);
        myRecipe.calculatePrice();

        Statistic statistic = Statistic.getInstance();
        statistic.addPersonalRecipes(myRecipe);

        return myRecipe;
    }


}