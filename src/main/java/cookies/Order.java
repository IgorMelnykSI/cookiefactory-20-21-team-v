package cookies;

import cookies.order.State;
import cookies.recipe.Recipe;

import java.util.*;
import java.text.SimpleDateFormat;

public class Order {
     private String orderID;
     private double price;
     private Date pickUpDate;
     private Store pickUpStore;
     private String pickUp="pickUp";
     private String homeDelivery="MarcelEat";
     private String theWay=null;
     private double deliveryFee=4;
     private String deliveryAddress;
     private List<CookieItem> cookieItems = new ArrayList<>();
     private List<Recipe> personalRecipes = new ArrayList<>();
    private State state;

    public Order(){
        orderID = getGuid();
        price = 0;
        pickUpDate = null;
        pickUpStore = null;
        deliveryAddress=null;
    }

    public static int Guid = 100;
    public static String getGuid() {

        Order.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        //获取时间戳  
        String time = dateFormat.format(now);
        String info = now + "";
        //获取三位随机数  
        //int ran=(int) ((Math.random()*9+1)*100); 
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran = 0;
        if (Order.Guid > 999) {
            Order.Guid = 100;
        }
        ran = Order.Guid;

        return time + info.substring(2, info.length()) + ran;
    }

    public List<CookieItem> getCookieItems(){
        return cookieItems;
}
    public Date getPickUpDate() {
        return pickUpDate;
    }
    public Store getPickUpStore(){return pickUpStore;}
    public String getDeliveryAddress(){return deliveryAddress;}
    //选择配送方式
    public void setTheWayToPick(int way){
        if(way==1){
                this.theWay=pickUp;
        }else if (way==2){
                this.theWay=homeDelivery;
        }else {
                this.theWay=null;
        }
    }
    public  String getTheWay(){
        return this.theWay;
    }
    public boolean judgeTheTime(){
        Date date = new Date();
        if(date.before(pickUpDate)){
            return true;
        }else {
            return false;
        }
    }
    public void changePickToDelivery(){
        if(theWay==pickUp&&judgeTheTime()){
            this.theWay=homeDelivery;
            this.price=price+deliveryFee*(1+0.5);
        }
    }



    public String getOrderID() {
        return orderID;
    }

    public double getPrice() {
        return price;
    }
//    public void setOrderID(String orderID) {
//        this.orderID = orderID;
//    }

    public void addCookieItem(CookieItem ci) {
        if(pickUpStore != null) {
            if (ci.getRecipeName().equals(pickUpStore.getMyBestOf().getName())
                    || ci.getRecipeName().equals(pickUpStore.getnationalBestOf().getName()))
                ci.changeToBestOf();
        }
        cookieItems.add(ci);

    }

    public void caculatePrice(){
        for(CookieItem ci : cookieItems){
            this.price += ci.getPrice();
        }
        if(theWay.equals("MarcelEat")){
            this.price=this.price+deliveryFee;
        }
    }

    public void caculateDiscountPrice(double loyalDiscount){
        //TODO caculate all the discount here
        if(theWay.equals("MarcelEat")){
            this.price = (price-deliveryFee)*(1-loyalDiscount)+deliveryFee;
        }else {
            this.price = price*(1-loyalDiscount);
        }

    }

//    public void setPrice(double price) {
//        this.price = price;
//    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
    public void setPickUpStore(Store pickUpStore) {
            this.pickUpStore= pickUpStore;
    }


    public void setDeliveryAddress(String deliveryAddress){
        this.deliveryAddress=deliveryAddress;
    }

    public List<Recipe> getPersonalRecipes(){return personalRecipes;}

    public void setState(State s){
        System.out.println("change state");
        state = s;
        state.handle();
    }

}
