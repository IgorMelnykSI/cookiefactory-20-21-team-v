package cookies.recipe;

import cookies.CookieFactory;

public abstract class BasicRecipeBuilder {
    protected CookieFactory factory;
    //public RecipeBuilder(Factory factory){this.factory = factory;}
    protected  BasicRecipe recipe = new BasicRecipe();
    public  abstract void buildCooking();
    public  abstract void buildDough();
    public  abstract void buildFlavour();
    public  abstract void buildMix();
    public abstract void buildTopping();
    public abstract void buildName();
    //返回产品对象
    public  Recipe getResult()
    {
        recipe.calculatePrice();
        return recipe;
    }
}
