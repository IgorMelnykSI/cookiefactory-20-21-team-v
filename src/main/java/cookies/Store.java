package cookies;

import cookies.recipe.*;

import java.util.*;

public class Store {
    private String name;
    private String address;
    protected String openTime;
    protected String closeTime;
    private double tax;
    private List<Order> historyOrders = new ArrayList<>();
    private Recipe myBestOf ;
    private Recipe nationalBestOf;
    private String country;
    private Inventory stock;
    private boolean hasProblem = false;
    private double[] position = {0,0};
    private List<Store> nearbyStore = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();

    public Store(String name, String address, String openHour, String openMin, String closeHour, String closeMin,double tax){
        this.name = name;
        this.address = address;
        this.openTime = openHour+':'+openMin;
        this.closeTime = closeHour+':'+closeMin;
        this.tax = tax;
        this.myBestOf = new Recipe("");
        this.nationalBestOf = new Recipe("");
        this.stock = new Inventory();
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes = recipes;
    }

    public void responseRecipeChange(List<Recipe> recipes){
        setRecipes(recipes);
    }

    public void initIngre(Integer quantity){
        this.stock.initIngredientQuantity(quantity);
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
        //TODO check correct ingredient
        //TODO check enough ingredient

        if(!stock.areRecipesAvailable(order.getRecipes())) return false;

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


    /**
     * tells if an ingredient is available with the quantity asked
     *
     * @param ingredient is the item to check
     * @param quantity   is the quantity to check
     * @return true if there is enough of the ingredient, false otherwise
     */
    public boolean isIngredientAvailable(Ingredient ingredient, Integer quantity) {
        return stock.isIngredientAvailable(ingredient, quantity);
    }

    /**
     * checks if all recipes are available in the store's stock
     *
     * @param recipes is a map with a Recipe as the key and an Integer as the quantity
     * @return true if all recipes are available and false if at least one of the recipes is not available
     */
    public boolean areRecipesAvailable(Map<Recipe, Integer> recipes) {
        return this.stock.areRecipesAvailable(recipes);
    }

    /**
     * updates the old stock value to the new one
     *
     * @param ingredient is the item to update
     * @param quantity   is the quantity to subtract to the old one
     * @return the new value, if the old quantity is too small, -1 is rerturned
     */
    public int subtractIngredientQuantity(Ingredient ingredient, Integer quantity) {
        return stock.subtractIngredientQuantity(ingredient, quantity);
    }

    /**
     * sets the quantity of the ingredient int the map to the quantity entered
     *
     * @param ingredient is the item to update
     * @param quantity   is the new quantity to put
     * @return false if the item does not exist, true if the item has been successfully updated
     */
    public boolean modifyIngredientQuantity(Ingredient ingredient, Integer quantity) {
        return stock.modifyIngredientQuantity(ingredient, quantity);
    }

    /**
     * Sets every ingredients in the stock to the given quantity
     *
     * @param quantity amount to set
     */
    public void modifyAllIngredientsQuantity(int quantity) {
        this.stock.modifyAllIngredientsQuantity(quantity);
    }

    /**
     * updates the Inventory after using the recipes given
     *
     * @param recipes is the Map of Recipes (key) and quantities (value - Integer) which
     *                are to remove from the Inventory
     */
    void updateAllQuantities(Map<Recipe, Integer> recipes) {
        this.stock.updateAllQuantities(recipes);
    }

    /**
     * Observer method to update an item no longer available in the CookieFactory
     *
     * @param ingredient is the ingredient to remove from the Inventory
     */
    public void updateRemoveIngredient(Ingredient ingredient) {
        this.stock.updateRemoveIngredient(ingredient);
    }

    /**
     * Observer method to update a new item now available in the CookieFactory
     *
     * @param ingredient is the ingredient to add to the Inventory
     */

    public void updateAddIngredient(Ingredient ingredient) {
        this.stock.updateAddIngredient(ingredient);
    }

    public void updateAddAllIngredients(List<Dough> doughs, List<Flavour> flavours, List<Topping> toppings) {
        stock.updateAddAllIngredients(doughs, flavours, toppings);
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

    public void setOpenTime(String openHour,String openMin) {
        this.openTime = openHour+':'+openMin;
    }

    public void setCloseTime(String closeHour,String closeMin) {
        this.closeTime = closeHour+':'+closeMin;
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

}