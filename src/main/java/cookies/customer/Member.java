package cookies.customer;

import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.recipe.Recipe;

import java.util.*;

public class Member extends Tourist{

    private int id;
    private boolean isLoyal;
    private static int numberOfAccount = -1;
    private int numCookiesOrdered;  //the number of my ordered cookies
    private double loyalDiscount;
    private List<Order> historyOrders;
    private String name;

    public Member(String name){
        this.name = name;
        this.isLoyal = false;
        this.id = ++numberOfAccount;
        numCookiesOrdered = 0;
        this.historyOrders = new ArrayList<>();
    }

    public Member(String name,Boolean isLoyal){
        this(name);
        this.isLoyal = isLoyal;
    }

    public void registerLoyal(){
        isLoyal = true;
    }//注册loyal计划

    public boolean hasDiscount(){     // check if the client has discount
        return loyalDiscount > 0;
    }

    /**
     * Calculate the amount of Loyal discount
     * Set the amount of discount and reset the counter of cookies ordered if over 30 cookies
     * Otherwise set 0 if is not suitable
     * @param cookieItems newly ordered
     */
    private void computeLoyalDiscount(Set<CookieItem> cookieItems) {
        if (!isLoyal){
            return;
        }
        cookieItems.forEach((cookieItem) -> numCookiesOrdered += cookieItem.getQuantity());

        if (numCookiesOrdered >= 30) {	// over 30 cookies
            this.loyalDiscount = 0.1;	// 10% discount
        }
    }

    public void saveOrderInHistory(Order order) {
        historyOrders.add(order);
        computeLoyalDiscount(order.getCookieItems());
    }

    // get the loyalty discount and reset for next time
    public double applyLoyaltyDiscount() {
        if(this.hasDiscount()){
            this.loyalDiscount = 0;
            this.numCookiesOrdered = 0;
            return 0.1;
        }else{
            return 0;
        }
    }

    // Member can use this function to use loyal discount
    // Otherwise he can use creatNoDiscountOrder() to make order without loyal discount
    public Order creatDiscountOrder(Map<Recipe, Integer> mp,int way, Date date, Store store, String address) throws MyException {
        Order newOrder = creatNoDiscountOrder(mp, way , date, store,address);
        newOrder.caculateDiscountPrice(applyLoyaltyDiscount());
        saveOrderInHistory(newOrder);
        return newOrder;
    }


    public Order createPrivateDiscountOrder(Map<Recipe, Integer> mp,int way, Date date, Store store, String address) throws MyException {
        Order newOrder = createPrivateOrder(mp, way , date, store,address);
        newOrder.caculateDiscountPrice(applyLoyaltyDiscount());
        saveOrderInHistory(newOrder);
        return newOrder;
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

    public int getNumCookiesOrdered() {
        return numCookiesOrdered;
    }
}
