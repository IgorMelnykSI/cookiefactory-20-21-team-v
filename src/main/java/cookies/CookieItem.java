package cookies;

import cookies.recipe.Recipe;

public class CookieItem {
    private int quantity;
    private String recipeName;
    private double recipePrice;
    private double price;
    private Recipe recipe;
    private boolean isPersonalized = false;//TODO


    public CookieItem(int quantity, Recipe recipe){
        this.quantity = quantity;
        this.recipe=recipe;
        this.recipeName = recipe.getName();
        this.recipePrice = recipe.getPrice();
    }

    public void setIsPersonalized(){
        this.isPersonalized=true;
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

    public boolean getIsPersonalized(){
        return isPersonalized;
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

    public  void calculatePrice(){
        recipePrice=recipe.getPrice();
        if(isPersonalized==false)
        this.price = quantity*recipePrice;
        else
            this.price=quantity*recipePrice*1.25;
    }

    public void changeToBestOf(){
        this.price = quantity*recipePrice*0.9;
    }


}
