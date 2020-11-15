//package manager;
//
//import cookies.manager.BrandManager;
//import cookies.CookieFactory;
//import cookies.recipe.Recipe;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BrandManagerTest {
//    private BrandManager brandManager=new BrandManager("Manager1");;
//
//
//
//    @Test
//    public void addRecipe(){
////        brandManager.getFactory().resetFactory();
//        assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),null);
//        Recipe recipeTest1=new Recipe("recipeTest1",9.8);
//        brandManager.addRecipe(recipeTest1);
//        assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),recipeTest1);
//    }
//
//    @Test
//    public void setMap(){
//        brandManager.getFactory().resetFactory();
//        brandManager.setMap(brandManager.getFactory().getRecipesList());
//        assertAll(
//                () -> assertTrue(brandManager.getMap().containsKey(brandManager.getFactory().getRecipe("recipe1"))),
//                () -> assertTrue(brandManager.getMap().containsKey(brandManager.getFactory().getRecipe("recipe2")))
//        );
//
//    }
//
//
//
//    @Test
//    public void addCount(){
//        brandManager.getFactory().resetFactory();
//        brandManager.setMap(brandManager.getFactory().getRecipesList());
//        assertAll(
//                () -> assertEquals(brandManager.getMap().get(brandManager.getFactory().getRecipe("recipe1")),0),
//                () -> assertEquals(brandManager.getMap().get(brandManager.getFactory().getRecipe("recipe2")),0)
//        );
//        brandManager.addCount("recipe1");
//        assertEquals(brandManager.getMap().get(brandManager.getFactory().getRecipe("recipe1")),1);
//
//    }
//
//    @Test
//    public void deleteRecipe(){
//       brandManager.getFactory().resetFactory();
//       brandManager.setMap(brandManager.getFactory().getRecipesList());
//       for(int i=0;i<10;i++) {
//           brandManager.addCount("recipe1");
//       }
//       brandManager.addCount("recipe2");
//       brandManager.deleteRecipe();
//       assertEquals(brandManager.getFactory().getRecipe("recipe2"),null);
//       Recipe recipeTest1=new Recipe("recipeTest1",9.8);
//       brandManager.addRecipe(recipeTest1);
//       for(int i=0;i<4;i++)
//           brandManager.addCount("recipeTest1");
//       brandManager.deleteRecipe();
//       assertEquals(brandManager.getFactory().getRecipe("recipeTest1"),null);
//
//    }
//
//    @Test
//    public void getFactory(){
//        brandManager.getFactory().resetFactory();
//        assertAll(
//                () -> assertNotEquals(brandManager.getFactory().getRecipe("recipe1"),null),
//                () -> assertNotEquals(brandManager.getFactory().getRecipe("recipe2"),null)
//        );
//
//
//    }
//
//    @Test
//    public void getMap(){
//        brandManager.getFactory().resetFactory();
//        brandManager.setMap(brandManager.getFactory().getRecipesList());
//        assertAll(
//                () -> assertTrue(brandManager.getMap().containsKey(brandManager.getFactory().getRecipe("recipe1"))),
//                () -> assertTrue(brandManager.getMap().containsKey(brandManager.getFactory().getRecipe("recipe2")))
//        );
//
//
//    }
//
//}
