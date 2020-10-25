package cookies;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Order {
     private String orderID;
     private double price;
     private Date pickUpDate;
     private ArrayList<CookieItem> cookieItems = new ArrayList<>();
    public Order(){
        orderID = getGuid();
        price = 0;
        pickUpDate = null;
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


    public Date getPickUpDate() {
        return pickUpDate;
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


    public void addCookieItem(CookieItem ci){
        cookieItems.add(ci);
    }
    public void caculatePrice(){
        for(CookieItem ci : cookieItems){
            this.price += ci.getPrice();
        }
    }
//    public void setPrice(double price) {
//        this.price = price;
//    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

}
