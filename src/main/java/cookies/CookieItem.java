package cookies;

import cookies.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class CookieItem {
    private int quantity;
    private String recipeName;
    private double recipePrice;
    private double price;
    private Recipe recipe;


    public CookieItem(int quantity, Recipe recipe){
        this.quantity = quantity;
        this.recipe=recipe;
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

    public Recipe getRecipe() {
        return recipe;
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
        this.price = quantity*recipePrice;
    }

    public void changeToBestOf(){
        this.price = quantity*recipePrice*0.9;
    }


}
