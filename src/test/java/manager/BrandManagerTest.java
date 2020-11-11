package manager;

import cookies.manager.BrandManager;
import cookies.CookieFactory;
import cookies.recipe.Recipe;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandManagerTest {
    private BrandManager brandManager=new BrandManager("Cookie");;



    @Test
    public void addRecipe(){
//        brandManager.getFactory().resetFactory();
        assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),null);
        Recipe recipeTest1=new Recipe("recipeTest1",9.8);
        brandManager.addRecipe(recipeTest1);
        assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),recipeTest1);
    }

    @Test
    public void setRecipes(){


    }

    @Test
    public void setCountCookies(){


    }

    @Test
    public void addCount(){


    }

    @Test
    public void deleteRecipe(){


    }

    @Test
    public void getFactory(){

    }

}
