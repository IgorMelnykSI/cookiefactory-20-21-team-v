package cookies.recipe;

import java.math.BigDecimal;
import java.util.Arrays;

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
        toppings = new Topping[3];
    }

    public boolean compareRecipe(Recipe re){
        if(dough.getType().equals(re.getDough().getType())){
            return true;
        }

        if(dough.getType()==re.getDough().getType()&&flavour.getType()==re.getFlavour().getType()&&mix.getType()==re.getMix().getType()&&
                cooking.getType()==re.getCooking().getType()&& Arrays.equals(toppings, re.getToppings())){
            return true;
        }

        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price){
        this.price=price;

    }
    public void calculatePrice(){
        this.price=0;
        for(Topping top:toppings) {
            if (top != null)
                price = price + top.getPrice();
        }

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
        this.cooking = new Cooking(cooking.getType(),cooking.getPrice());
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = new Flavour(flavour.getType(),flavour.getPrice());
    }

    public void setDough(Dough dough) {
        this.dough = new Dough(dough.getType(),dough.getPrice());
    }

    public void setMix(Mix mix) {
        this.mix = new Mix(mix.getType(),mix.getPrice());
    }

    public void setToppings(Topping[] toppings) {
        this.toppings = Arrays.copyOfRange(toppings,0,3);
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
