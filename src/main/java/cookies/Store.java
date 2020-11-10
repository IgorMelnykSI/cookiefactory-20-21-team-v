package cookies;

import cookies.recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private String name;
    private String address;
    protected String openTime;
    protected String closeTime;
    private double tax;
    private List<Order> historyOrders = new ArrayList<>();
    private Map<String, Integer> historyRecipes = new HashMap<>();
    private Recipe myBestOf;
    private Recipe nationalBestOf;
    private String country;

    public Store(String name, String address, String openTime, String closeTime, double tax){
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.tax = tax;
    }

    public void checkOrder(Order order){
        //TODO check correct ingredient
        //TODO check enough ingredient
        historyOrders.add(order);
        calculateRecipePopularity();
    }

    public void calculateRecipePopularity(){

        /*
        for (Order order : historyOrders) {
            for (CookieItem cookieItem : order.getCookieItems()) {
                if (cookieItem.getIsPersonalized()) {
                    //todo from here
                    int number = historyRecipes.get("personal");
                    historyRecipes.put("personal", number + order.getItems().get(cookieItem));
                } else {
                    if (historyRecipes.containsKey(cookieItem.getName())) {
                        int number = historyRecipes.get(cookieItem.getName());
                        historyRecipes.put(cookieItem.getName(), number + order.getItems().get(cookieItem));
                    } else {
                        historyRecipes.put(cookieItem.getName(), order.getItems().get(cookieItem));
                    }
                }
            }
        }

         */
    }

    public String getName(){return name;}
    public String getAddress(){return address;}

    public String getCloseTime() {
        return closeTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public double getTax(){return tax;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setNationalBestOf(Recipe BestOf){
        this.nationalBestOf = BestOf;
    }

    public Recipe getMyBestOf(){
        return myBestOf;
    }

    public Recipe getnationalBestOf(){
        return nationalBestOf;
    }

    public List<Order> getHistoryOrders(){
        return historyOrders;
    }
}
