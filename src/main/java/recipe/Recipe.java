package java.recipe;

public class Recipe {
    private String name;
    private double price;
    private Dough dough;
    private Flavour flavour;
    private Mix mix;
    private Cooking cooking;
    Topping[] toppings;

    Recipe(String name, double price){
        this.name=name;
        this.price=price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double prcie) {
        this.price = prcie;
    }

    public String getName() {
        return name;
    }

    public double getPrcie() {
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
}
