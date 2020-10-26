package cookies;

import cookies.recipe.Recipe;

public class CookieItem {
    private int quantity;
    private String recipeName;
    private final double recipePrice;
    private double price;

    public CookieItem(int quantity, Recipe recipe){
        this.quantity = quantity;
        this.recipeName = recipe.getName();
        this.recipePrice = recipe.getPrice();
        calculatePrice();
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    private void calculatePrice(){
        this.price = quantity*recipePrice;
    }
}
