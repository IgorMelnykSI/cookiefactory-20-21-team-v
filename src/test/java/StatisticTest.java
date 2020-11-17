import cookies.Statistic;
import cookies.recipe.Cooking;
import cookies.recipe.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {

    private Recipe myRecipe;
    private Statistic statistic;
    @BeforeEach
    public void init(){
        myRecipe=new Recipe("privateRecipe");

        statistic = Statistic.getInstance();
    }

    @Test
    void getInstance() {
        Statistic statistic1 = Statistic.getInstance();
        Statistic statistic2 = Statistic.getInstance();
        assertTrue(statistic==statistic2);
        assertTrue(statistic1==statistic2);
        assertEquals(statistic.getPersonalRecipes().size(),statistic2.getPersonalRecipes().size());
        assertEquals(statistic1.getPersonalRecipes().size(),statistic2.getPersonalRecipes().size());
    }

    @Test
    void addPersonalRecipes() {
        statistic.addPersonalRecipes(myRecipe);

        assertEquals(1,statistic.getPersonalRecipes().size());
        assertEquals(1,myRecipe.getPopularity());
    }

    @Test
    void nationalBestOf() {
        assertTrue(statistic.nationalBestOf()==null);

        Recipe myRecipe2=new Recipe("privateRecipe2");
//        statistic.addPersonalRecipes(myRecipe2);
//        myRecipe2.addPopularity();
//        assertEquals("privateRecipe2",statistic.nationalBestOf().getName());
//
//        statistic.addPersonalRecipes(myRecipe);
//        myRecipe.addPopularity();
//        assertEquals("privateRecipe2",statistic.nationalBestOf().getName());
    }
}