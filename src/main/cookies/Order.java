package cookies;

import java.util.Date;

public class Order {
     private long orderID;
     private double price;
     private Date pickUpDate;

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public long getOrderID() {
        return orderID;
    }

    public double getPrice() {
        return price;
    }
    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

}
