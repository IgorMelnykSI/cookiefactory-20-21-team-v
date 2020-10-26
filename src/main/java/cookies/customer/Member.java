package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.recipe.Recipe;

import java.util.Date;
import java.util.Map;

public class Member extends Tourist{

    private int id;
    private boolean isLoyal;
    private static int numberOfAccount = -1;
    private int cookiesOrdered;  //the number of my ordered cookies
    private double loyalDiscount;
    private String name;

    public Member(String name){
        this.name = name;
        this.isLoyal = false;
        this.id = ++numberOfAccount;
        cookiesOrdered = 0;
    }

    public void registerLoyal(){
        isLoyal = true;
        loyalDiscount = 0.1;
    }

    public boolean hasDiscount(){     // check if the client has discount
        return loyalDiscount > 0;
    }

    // get the loyalty discount and reset for next time
    public double applyLoyaltyDiscount() {
        if(this.hasDiscount()){
            this.loyalDiscount = 0;
            this.cookiesOrdered = 0;
            return 0.1;
        }
        return 0;
    }

    public Order creatDiscountOrder(Map<Recipe, Integer> mp, Date date, Store store){
        Order order = new Order();
        for(Recipe recipe : mp.keySet()){
            order.addCookieItem(new CookieItem(mp.get(recipe),recipe));
        }
        order.setPickUpDate(date);
        order.caculatePrice(applyLoyaltyDiscount());
        return order;
    }

    public void setLoyal(boolean loyal) {
        this.isLoyal = loyal;
    }

    public int  getId() {
        return id;
    }

    public boolean isLoyal() {
        return isLoyal;
    }

    public String getName() {
        return name;
    }

    public int getCookiesOrdered() {
        return cookiesOrdered;
    }
}
