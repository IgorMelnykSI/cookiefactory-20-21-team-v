package cookies;

import cookies.recipe.Recipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieFactoryTest {
    CookieFactory cook=new CookieFactory();

    @Test
    void resetFactory() {
        cook.resetFactory();
        assertEquals(cook.getStoreList().size(),0);
    }

    @Test
    void getRecipesList() {
        assertEquals(cook.getRecipesList().size(),0);
    }

    @Test
    void getRecipe() {
        Recipe recipe1=new Recipe("recipe1",9.8);
        cook.addRecipe(recipe1);
        assertEquals(cook.getRecipe("recipe1"),recipe1);
        assertEquals(cook.getRecipe("recipe2"),null);
    }

    @Test
    void getStore() {
        Store store1 = new Store("store1","address1","8:30","19:00",0.2);
        cook.addStore(store1);
        assertEquals(cook.getStore("store1"),store1);
        assertEquals(cook.getStore("recipe2"),null);
    }

    @Test
    void addRecipe() {
        assertEquals(cook.getRecipe("recipe1"),null);
        Recipe recipe1=new Recipe("recipe1",9.8);
        cook.addRecipe(recipe1);
        assertEquals(cook.getRecipe("recipe1"),recipe1);

    }

    @Test
    void deleteRecipe() {
        Recipe recipe2=new Recipe("recipe2",9.5);
        cook.addRecipe(recipe2);
        assertTrue(cook.getRecipe("recipe2")==recipe2);
        cook.deleteRecipe("recipe2");
        assertTrue(cook.getRecipe("recipe2")==null);
    }

    @Test
    void addStore() {
        assertEquals(cook.getStore("store2"),null);
        Store store2 = new Store("store2","address2","8:00","18:00",0.15);
        cook.addStore(store2);
        assertEquals(cook.getStore("store2"),store2);

    }

    @Test
    void deleteStore() {
        Store store2 = new Store("store2","address2","8:00","18:00",0.15);
        cook.addStore(store2);
        assertTrue(cook.getStore("store2")==store2);
        cook.deleteRecipe("store2");
        assertTrue(cook.getRecipe("store2")==null);
    }

    @Test
    void getStoreList() {
        assertTrue(cook.getStoreList().isEmpty());

    }
}