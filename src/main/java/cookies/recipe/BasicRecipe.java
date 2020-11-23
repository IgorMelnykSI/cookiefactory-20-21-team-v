package cookies.recipe;

import java.util.ArrayList;
import java.util.List;

public class BasicRecipe {
    private String name;
    private Dough dough;
    private Flavour flavour;
    private Mix mix;
    private Cooking cooking;
    private List<Topping> toppings = new ArrayList<>();

    private BasicRecipe(BasicRecipeBuilder builder){
        this.dough = builder.dough;
        this.flavour = builder.flavour;
        this.cooking = builder.cooking;
        this.mix = builder.mix;
        this.toppings.clear();
        for (Topping topping:builder.toppings) {
             this.toppings.add(topping);
        }
    }

    public static class BasicRecipeBuilder {
        private String name;
        private Dough dough;
        private Flavour flavour;
        private Mix mix;
        private Cooking cooking;
        private List<Topping> toppings = new ArrayList<>();

        public BasicRecipeBuilder(String name){
            this.name = name;
        }

        public BasicRecipeBuilder withDough(Dough dough){
            this.dough = dough;
            return this;
        }

        public BasicRecipeBuilder withFlavour(Flavour flavour){
            this.flavour = flavour;
            return this;
        }

        public BasicRecipeBuilder withMix(Mix mix){
            this.mix = mix;
            return this;
        }

        public BasicRecipeBuilder withCooking(Cooking cooking){
            this.cooking = cooking;
            return this;
        }

        public BasicRecipeBuilder withToppings(List<Topping> toppings){
            this.toppings.clear();
            for (Topping topping:toppings) {
                this.toppings.add(topping);
            }
            return this;
        }

        public BasicRecipe build(){
            return new BasicRecipe(this);
        }
    }
}

