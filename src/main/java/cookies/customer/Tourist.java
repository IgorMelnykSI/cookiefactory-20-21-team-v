package cookies.customer;

import cookies.*;
import cookies.order.FinishState;
import cookies.order.MyException;
import cookies.recipe.*;


import java.util.*;


public class Tourist{

    private boolean isPrivateCookieItem=false;
    ArrayList<Recipe> privateRecipes = new ArrayList<>();
    CookieFactory factory = new CookieFactory();
    Order order;

    public Order creatNoDiscountOrder(Map<Recipe, Integer> mp,int way, Date date, Store store,String deliveryAddress) throws MyException {
        order = new Order(mp,way,date,store,deliveryAddress);
        order.caculatePrice();
        return order;
    }

     public Order createPrivateOrder(Map<Recipe, Integer> mp,int way, Date date, Store store,String deliveryAddress) throws MyException {
        order = new Order(mp,way,date,store,deliveryAddress);
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

    public void pickup(){
        if(this.order.getTheWay()=="MarcelEat"){
            MarcelEat marcelEat=new MarcelEat();
            marcelEat.pickTheOrder(this.order);
            this.order.setState(new FinishState());
        }else {
            this.order.pickTheOrder(order);
            this.order.setState(new FinishState());
        }
    }

}