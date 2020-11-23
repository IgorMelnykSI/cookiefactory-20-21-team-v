package cookies.customer;

import cookies.*;
import cookies.recipe.*;


import java.util.*;


public class Tourist {

    private boolean isPrivateCookieItem=false;
    ArrayList<Recipe> privateRecipes = new ArrayList<>();
    CookieFactory factory = new CookieFactory();

    public Order creatNoDiscountOrder(Map<Recipe, Integer> mp,int way, Date date, Store store,String deliveryAddress) throws MyException {
        Order order = new Order();
        order.setTheWayToPick(way);
         if (order.getTheWay()=="pickUp"){
             order.setPickUpDate(date);
             order.setPickUpStore(store);
         }else if(order.getTheWay()=="MarcelEat"){
             order.setPickUpStore(store);//这是为了确定客户选择哪家店下订单
             order.setDeliveryAddress(deliveryAddress);
         }else {
             throw new MyException("非法配送方式, 请输入序号选择配送方式:" +
                     "\n1. Pick up" +
                     "\n2. MarcelEat");
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
        order.setTheWayToPick(way);
        if (order.getTheWay()=="pickUp"){
            order.setPickUpDate(date);
            order.setPickUpStore(store);
        }else if(order.getTheWay()=="MarcelEat"){
            order.setDeliveryAddress(deliveryAddress);
        }else {
            throw new MyException("非法配送方式, 请输入序号选择配送方式:" +
                    "\n1. Pick up" +
                    "\n2. MarcelEat");
        }
        if(store.hasProblem()){
            throw new MyException("The store has technical problems, please choose another store\n");
        }
//

         if(store.isBusy(date)){
             throw new MyException("The store is busy, please choose another store\n");
         }
        for(Recipe recipe : mp.keySet()){
            CookieItem item=new CookieItem(mp.get(recipe),recipe);
            order.addCookieItem(item);
        }
        order.caculatePrice();
        return order;
    }

    public void createPrivateRecipe(String name,String cookingName,String doughName,String flavourName,String mixName,String toppingNames){
        String[] topName=toppingNames.split(" and ");
        List<Topping> topList = new ArrayList<>();
        for(String topping:topName){
            topList.add(this.factory.getTopping(topping));
        }
        Cooking cooking = this.factory.getCooking(cookingName);
        Dough dough = this.factory.getDough(doughName);
        Flavour flavour = this.factory.getFlavour(flavourName);
        Mix mix = this.factory.getMix(mixName);
        PrivateRecipe recipe = new PrivateRecipe(name,cooking,dough,flavour,mix,topList);
        this.privateRecipes.add(recipe);
    }

    public ArrayList<Recipe> getPrivateRecipes() {
        return privateRecipes;
    }
}