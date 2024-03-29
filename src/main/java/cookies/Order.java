package cookies;

import cookies.orderState.*;
import cookies.recipe.Recipe;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Order implements Subject {
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
        state=null;
    }

    public Order(Map<Recipe, Integer> mp,int way,Date date, Store store,String address) throws MyException, ParseException {
        orderID = getGuid();
        setTheWayToPick(way);
        setInformation(mp,date,store,address);
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

    public void setInformation(Map<Recipe, Integer> mp,Date date,Store store,String deliveryAddress) throws MyException, ParseException {
        getAllCookieItems(mp);
        if (getTheWay()=="pickUp"){
            setPickUpDate(date);
            setPickUpStore(store);
        }else if(getTheWay()=="MarcelEat"){
            setPickUpDate(date);
            setPickUpStore(store);//这是为了确定客户选择哪家店下订单
            setDeliveryAddress(deliveryAddress);
        }else {
            throw new MyException("Illegal entry data, please enter a number to choose the delivery method:" +
                    "\n1. Pick up" +
                    "\n2. MarcelEat");
        }

        if(store.hasProblem()){
            setState(new FailState());
            throw new MyException("The store has technical problems, please choose another store\n");
        }
        if(store.isBusy(date)){
            setState(new FailState());
            throw new MyException("The store is busy, please choose another store\n");
        }
        if(!store.checkOrder(this)){
            setState(new FailState());
            throw new MyException("There is not enough ingredients");
        }

        setState(new WaitPayState());
    }

    public void pay(){
        setState(new ConfirmState());
    }

    public  String getTheWay(){
        return this.theWay;
    }

    public boolean judgeTheTime(String time) throws ParseException {
        Date date = new Date();
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = dateFormat2.parse(time);

        if(date.before(pickUpDate)){
            return true;
        }else {
            return false;
        }
    }
    public void changePickToDelivery(String time) throws ParseException {
        if(theWay==pickUp&&judgeTheTime(time)){
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
    public void getAllCookieItems(Map<Recipe, Integer> mp){
        for(Recipe recipe : mp.keySet()){
            CookieItem item=new CookieItem(mp.get(recipe),recipe);
            item.calculatePrice();
            addCookieItem(item);
        }
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

    public Map<Recipe,Integer> getRecipes(){
        Map<Recipe,Integer> recipes=new HashMap<>();
        for (CookieItem ck:this.cookieItems){
            recipes.put(ck.getRecipe(),ck.getQuantity());
        }
        return recipes;
    }

    public void setState(State s){
        state = s;
        String instruction=state.handle(this);
    }
    public State getState(){
        return this.state;
    }

    @Override
    public void pickTheOrder(Order order) {
        System.out.println("pick the order");

    }
}
