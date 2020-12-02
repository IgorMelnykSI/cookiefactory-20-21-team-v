package manager;

import cookies.manager.BrandManager;
import cookies.CookieFactory;
import cookies.recipe.Recipe;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class BrandManagerTest {
    private BrandManager brandManager=new BrandManager("Manager1");;



    @Test
    public void addRecipe(){
//        brandManager.getFactory().resetFactory();
        assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),null);
        Recipe recipeTest1=new Recipe("recipeTest1");
        brandManager.getFactory().addRecipe(recipeTest1);
        assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),recipeTest1);
    }

    @Test
    public void getFactory(){
        brandManager.getFactory().resetFactory();
        assertAll(
                () -> assertNotEquals(brandManager.getFactory().getRecipe("recipe1"),null),
                () -> assertNotEquals(brandManager.getFactory().getRecipe("recipe2"),null)
        );


    }
}
