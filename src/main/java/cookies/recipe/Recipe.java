package cookies.recipe;

import java.math.BigDecimal;

public class Recipe {
    private String name;
    private double price;
    private Dough dough;
    private Flavour flavour;
    private Mix mix;
    private Cooking cooking;
    private Topping[] toppings;

    public Recipe(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price){
        this.price=price;

    }
    public void calculatePrice(){
        this.price=0;
        for(Topping top:toppings)
            price=price+top.getPrice();
        this.price= price+dough.getPrice()+flavour.getPrice()+ mix.getPrice()+ cooking.getPrice();
        BigDecimal b = new BigDecimal(price);
        price = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setCooking(Cooking cooking) {
        this.cooking = cooking;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setMix(Mix mix) {
        this.mix = mix;
    }

    public void setToppings(Topping[] toppings) {
        this.toppings = toppings;
    }

    public Cooking getCooking(){
        return cooking;
    }

    public Flavour getFlavour(){
        return flavour;
    }

    public Dough getDough(){
        return dough;
    }

    public Mix getMix(){
        return mix;
    }

    public Topping[] getToppings(){
        return toppings;
    }
}
