package cookies.recipe;

import cookies.CookieFactory;

public class BasicRecipeCreator {
    private BasicRecipeBuilder builder;
    public BasicRecipeCreator(CookieFactory factory, BasicRecipeBuilder builder)
    {
        this.builder=builder;
        this.builder.factory = factory;
    }
    //产品构建与组装方法
    public Recipe build()
    {
        builder.buildCooking();
        builder.buildDough();
        builder.buildFlavour();
        builder.buildMix();
        builder.buildTopping();
        builder.buildName();
        return builder.getResult();
    }
}
