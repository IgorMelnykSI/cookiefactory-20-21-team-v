package cookies.recipe;

import java.util.List;

public class PrivateRecipe extends Recipe {

    private double price;
    private List<Dough> doughs;
    private List<Flavour> flavours;
    private List<Mix> mixes;
    private List<Cooking> cookings;
    private List<Topping> toppings;

    public PrivateRecipe(String name, Cooking cook, Dough dough, Flavour flavour, Mix mix, List<Topping> toppings) {
        super(name, cook, dough, flavour, mix, toppings);
    }

    public PrivateRecipe(String name, List<Cooking> cookings, List<Dough> doughs, List<Flavour> flavours, List<Mix> mixes, List<Topping> toppings) {
        super(name);
        this.cookings = cookings;
        this.doughs = doughs;
        this.flavours = flavours;
        this.mixes = mixes;
        this.toppings = toppings;
        calPrice();
    }

    public void calPrice(){
        this.price = 0;
        for(Cooking cooking:this.cookings){
            this.price += cooking.getPrice();
        }
        for(Dough dough:this.doughs){
            this.price += dough.getPrice();
        }
        for(Flavour flavour:this.flavours){
            this.price += flavour.getPrice();
        }
        for(Mix mix:this.mixes){
            this.price += mix.getPrice();
        }
        for(Topping topping:this.toppings){
            this.price += topping.getPrice();
        }
        super.setPrice(this.price);
    }

    @Override
    public double getPrice() {
        return super.getPrice()*1.25;
    }
}