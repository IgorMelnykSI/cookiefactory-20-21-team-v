package cookies;

import cookies.recipe.Dough;
import cookies.recipe.Flavour;
import cookies.recipe.Recipe;
import cookies.recipe.Topping;

import java.util.*;

public class Store {
    private String name;
    private String address;
    protected int[] openTime= new int[2];
    protected int[] closeTime = new int[2];
    private double tax;
    private List<Order> historyOrders = new ArrayList<>();
    private Recipe myBestOf ;
    private Recipe nationalBestOf;
    private String country;
    private boolean hasProblem = false;
    private HashMap<Dough,Integer> cookingAvailable;
    private HashMap<Flavour,Integer> flavourAvailable;
    private HashMap<Topping,Integer> toppingAvailable;
    private double[] position = {0,0};
    private List<Store> nearbyStore = new ArrayList<>();

    public Store(String name, String address, int openHour, int openMin, int closeHour, int closeMin,double tax){
        this.name = name;
        this.address = address;
        this.openTime[0] = openHour;
        this.openTime[1] = openMin;
        this.closeTime[0] = closeHour;
        this.closeTime[1]=closeMin;
        this.tax = tax;
        this.myBestOf = new Recipe("");
        this.nationalBestOf = new Recipe("");
    }

    public void setPosition(double X, double Y) {
        this.position[0] = X;
        this.position[1] = Y;
    }

    public double[] getPosition(){
        return position;
    }
    public boolean checkOrder(Order order){
        if (this.openTime[0]>order.getPickUpHour()||this.closeTime[0]<order.getPickUpMin()){
            return false;
        }
        if (this.openTime[0]==order.getPickUpHour()&&this.openTime[1]>order.getPickUpMin()||this.closeTime[0]==order.getPickUpMin()&&this.closeTime[1]<order.getPickUpMin()){
            return false;
        }

        //TODO check correct ingredient
        //TODO check enough ingredient


        saveOrder(order);
        return true;
    }

    public void saveOrder(Order order){
        deleteExpiredOrder();
        historyOrders.add(order);
        calculateRecipePopularity();
    }

    public void deleteExpiredOrder(){
        Date today=new Date();
        List<Order> expiredOrders = new ArrayList<>();
        List<Recipe> expiredRecipes = new ArrayList<>();

        if(historyOrders.size()==0){
            return;
        }

        for(Order order:historyOrders){
            int days = (int) ((today.getTime() - order.getPickUpDate().getTime()) / (1000*3600*24));
            if(days>30){
                expiredOrders.add(order);
                //cookieItems.addAll(order.getCookieItems());

            }
        }

        for(Order order:expiredOrders){
            historyOrders.remove(order);
        }
    }

    public void calculateRecipePopularity(){
        Map<Recipe, Integer> historyRecipes = new HashMap<>();

        for (Order order : historyOrders) {
            for (CookieItem cookieItem : order.getCookieItems()) {
                if (cookieItem.getIsPersonalized()) {
//                    todo from here
//                    int number = historyRecipes.get("personal");
//                    historyRecipes.put("personal", number);
                }
            }
        }

    }

    public String getName(){return name;}
    public String getAddress(){return address;}

    public int getCloseHour() {
        return closeTime[0];
    }

    public int getOpenHour() {
        return openTime[0];
    }
    public int getOpenMin(){
        return openTime[1];
    }
    public int getCloseMin(){
        return closeTime[1];
    }

    public double getTax(){return tax;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenTime(int openHour,int openMin) {
        this.openTime[0] = openHour;
        this.openTime[1] = openMin;
    }

    public void setCloseTime(int closeHour,int closeMin) {
        this.closeTime[0] = closeHour;
        this.closeTime[1] = closeMin;
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

    public void setMyBestOf(Recipe BestOf){
        myBestOf = BestOf;
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

    public boolean hasProblem(){
        return hasProblem;
    }

    public void setHasProblem(boolean i){
        hasProblem = i;
    }

    public List<Store> returnNearbyStores(){
        if(hasProblem){
            return this.nearbyStore;
        }
        return null;
    }

    public HashMap<Dough, Integer> getCookingAvailable() {
        return cookingAvailable;
    }

    public HashMap<Flavour, Integer> getFlavourAvailable() {
        return flavourAvailable;
    }

    public HashMap<Topping, Integer> getToppingAvailable() {
        return toppingAvailable;
    }

    public void setCookingAvailable(HashMap<Dough, Integer> cookingAvailable) {
        this.cookingAvailable = cookingAvailable;
    }

    public void setFlavourAvailable(HashMap<Flavour, Integer> flavourAvailable) {
        this.flavourAvailable = flavourAvailable;
    }

    public void setToppingAvailable(HashMap<Topping, Integer> toppingAvailable) {
        this.toppingAvailable = toppingAvailable;
    }
}