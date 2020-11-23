package cookies.recipe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Recipe {
    private String name;
    private double price;
    private Dough dough;
    private Flavour flavour;
    private Mix mix;
    private Cooking cooking;
    private List<Topping> toppings;
    private int popularity;
    private int storePopularity;

    public Recipe(String name){
        this.name=name;
        popularity = 0;
        storePopularity = 0;
    }

    public Recipe(String name, Cooking cooking, Dough dough, Flavour flavour, Mix mix, List<Topping> toppings){
        this.name=name;
        popularity = 0;
        storePopularity = 0;
        this.cooking = cooking;
        this.flavour = flavour;
        this.dough = dough;
        this.mix = mix;
        this.toppings = toppings;
        calculatePrice();
    }

    public boolean compareRecipe(Recipe re){
        boolean flag = false;
        if(re==null)
            return false;

        if(dough.getType().equals(re.getDough().getType()) &&flavour.getType().equals(re.getFlavour().getType())&&
                mix.getType().equals(re.getMix().getType())&&cooking.getType().equals(re.getCooking().getType())){
            for(int i=0;i<toppings.size();i++){
                if(toppings.get(i).getType().equals(re.getToppings().get(i).getType())){
                    flag = true;
                }else {
                    return false;
                }
            }

        }

        return flag;
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

    public void setToppings(List<Topping> toppings) {
        this.toppings = new ArrayList<>();
        if(toppings.size()<=3&&toppings.size()>0){
            Iterator<Topping> it = toppings.iterator();
            while (it.hasNext()) {
                Topping s = it.next();
                Topping newS = new Topping(s.getType(),s.getPrice());
                this.toppings.add(newS);
            }
        }
        //this.toppings = toppings;
    }

    public void addPopularity(){popularity++;}

    public void minusPopularity(){
        popularity--;
    }

    public int getPopularity(){return popularity;}

    public void addStorePopularity(){storePopularity++;}

    public void resetStorePopularity(){
        storePopularity = 0;
    }

    public void minusStorePopularity(){
        storePopularity--;
    }

    public int getStorePopularity(){return storePopularity;}

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

    public List<Topping> getToppings(){
        return toppings;
    }

}
