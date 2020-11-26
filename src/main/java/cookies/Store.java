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
    private HashMap<Dough,Integer> doughAvailable = new HashMap<>();
    private boolean hasProblem = false, lackIngredient = false;
    private HashMap<Flavour,Integer> flavourAvailable = new HashMap<>();
    private HashMap<Topping,Integer> toppingAvailable =new HashMap<>();
    private double[] position = {0,0};
    private List<Store> nearbyStore = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();

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
        doughAvailable.put(new Dough("Plain",2.0),100);
        doughAvailable.put(new Dough("Chocolate",2.4),100);
        doughAvailable.put(new Dough("Peanut butter",2.5),100);
        doughAvailable.put(new Dough("Oatmeal",2.6),100);
        flavourAvailable.put(new Flavour("Vanilla",0.1),100);
        flavourAvailable.put(new Flavour("Cinnamon",0.1),100);
        flavourAvailable.put(new Flavour("Chili",0.1),100);
        toppingAvailable.put(new Topping("White chocolate",0.2),500);
        toppingAvailable.put(new Topping("Milk chocolate",0.2),500);
        toppingAvailable.put(new Topping("M&M’s™",0.3),500);
        toppingAvailable.put(new Topping("Reese’s buttercup",0.4),500);
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes = recipes;
    }

    public void responseRecipeChange(List<Recipe> recipes){
        setRecipes(recipes);
    }
    public void addDough(Dough dough, int n){
        doughAvailable.put(dough,n);
    }

    public void removeDough(Dough dough){
        doughAvailable.remove(dough);
    }

    public void addFlacvour(Flavour flavour, int n){
        flavourAvailable.put(flavour,n);
    }

    public void removeFlacvour(Flavour flavour){
        flavourAvailable.remove(flavour);
    }
    public void addTopping(Topping topping, int n){
        toppingAvailable.put(topping,n);
    }

    public void removeTopping(Topping topping){
        toppingAvailable.remove(topping);
    }


    public boolean isBusy(Date date){
        int num = 0;
        for(Order order: historyOrders){
            if(Math.abs(order.getPickUpDate().getTime()-date.getTime())<900000) {
                num++;
            }
        }
        return num >= 20;
    }

    public void setPosition(double X, double Y) {
        this.position[0] = X;
        this.position[1] = Y;
    }

    public void response(List<Store> nearbyStore){
        setNearbyStore(nearbyStore);
    }
    public void setNearbyStore(List<Store> nearbyStore) {
        this.nearbyStore = nearbyStore;
    }

    public double[] getPosition(){
        return position;
    }
    public boolean checkOrder(Order order){
        for(CookieItem cookieItem:order.getCookieItems()) {
            Dough dough = cookieItem.getRecipe().getDough();
            Flavour flavour = cookieItem.getRecipe().getFlavour();
            if (doughAvailable.get(dough) < cookieItem.getQuantity()) {
                return false;
            } else {
                int n = doughAvailable.get(dough) - cookieItem.getQuantity();
                doughAvailable.put(dough, n);
            }
            if (flavourAvailable.get(flavour) < cookieItem.getQuantity()){
                return false;
            }else {
                int n = flavourAvailable.get(flavour) - cookieItem.getQuantity();
                flavourAvailable.put(flavour,n);
            }
            for(Topping topping:cookieItem.getRecipe().getToppings())
                if(toppingAvailable.get(topping) < cookieItem.getQuantity()) {
                    return false;
                }else{
                    int n = toppingAvailable.get(topping) - cookieItem.getQuantity();
                    toppingAvailable.put(topping,n);
                }
        }
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
//        calculateRecipePopularity();
    }

    public void deleteExpiredOrder(){
        Date today=new Date();
        List<Order> expiredOrders = new ArrayList<>();

        if(historyOrders.size()==0){
            return;
        }

        for(Order order:historyOrders){
            int days = (int) ((today.getTime() - order.getPickUpDate().getTime()) / (1000*3600*24));
            if(days>30){
                expiredOrders.add(order);
                for(Recipe recipe:order.getPersonalRecipes()){
                    recipe.minusPopularity();
                }
            }
        }

        for(Order order:expiredOrders){
            historyOrders.remove(order);
        }
    }


    public void checkIngredients(Order order){
        List<CookieItem> cookieItems;
        cookieItems = order.getCookieItems();
        for(CookieItem cookieItem:cookieItems){
            Recipe recipe = cookieItem.getRecipe();
            if(doughAvailable.get(recipe.getDough())<20){
                lackIngredient=true;
            }
            List<Topping> toppings = recipe.getToppings();
            for(Topping topping:toppings) {
                if (toppingAvailable.get(topping) < 20) {
                    lackIngredient=true;
                }
            }
            if(flavourAvailable.get(recipe.getFlavour())<20){
                lackIngredient=true;
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
        return doughAvailable;
    }

    public HashMap<Flavour, Integer> getFlavourAvailable() {
        return flavourAvailable;
    }

    public HashMap<Topping, Integer> getToppingAvailable() {
        return toppingAvailable;
    }

    public void setCookingAvailable(HashMap<Dough, Integer> doughAvailable) {
        this.doughAvailable = doughAvailable;
    }

    public void setFlavourAvailable(HashMap<Flavour, Integer> flavourAvailable) {
        this.flavourAvailable = flavourAvailable;
    }

    public void setToppingAvailable(HashMap<Topping, Integer> toppingAvailable) {
        this.toppingAvailable = toppingAvailable;
    }
}