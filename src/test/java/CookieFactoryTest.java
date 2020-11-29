import cookies.CookieFactory;
import cookies.Store;
import cookies.recipe.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CookieFactoryTest {
    CookieFactory cook=new CookieFactory();

    @Test
    void resetFactory() {
        cook.resetFactory();
        assertEquals(cook.getStoreList().size(),1);
    }

    @Test
    void getRecipesList() {
        assertEquals(cook.getRecipesList().size(),2);
    }

    @Test
    void setMap(){
        cook.resetFactory();
        cook.setMap();
        assertAll(
                () -> assertTrue(cook.getMap().containsKey(cook.getRecipe("recipe1"))),
                () -> assertTrue(cook.getMap().containsKey(cook.getRecipe("recipe2")))
        );
    }

    @Test
    void getRecipe() {
        Recipe recipeTest=new Recipe("recipeTest");//9.8
        cook.addRecipe(recipeTest);
        assertEquals(cook.getRecipe("recipeTest"),recipeTest);
        assertEquals(cook.getRecipe("recipeTestNo"),null);
    }

    @Test
    void getStore() {
        Store storeTest=new Store("storeTest","address1","8:30","19:00",0.2);
        cook.addStore(storeTest);
        assertEquals(cook.getStore("storeTest"),storeTest);
        assertEquals(cook.getStore("storeTestNo"),null);
    }

    @Test
    void addRecipe() {
        assertEquals(cook.getRecipe("recipeTest1"),null);
        Recipe recipeTest1=new Recipe("recipeTest1");//9.8
        cook.addRecipe(recipeTest1);
        assertEquals(cook.getRecipe("recipeTest1"),recipeTest1);

    }

    @Test
    void deleteRecipe() {
        Recipe recipeTest2=new Recipe("recipeTest2");//9.5
        cook.addRecipe(recipeTest2);
        assertTrue(cook.getRecipe("recipeTest2")==recipeTest2);
        cook.deleteRecipe("recipeTest2");
        assertTrue(cook.getRecipe("recipeTest2")==null);
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
    void addCount(){
        cook.resetFactory();
        cook.setMap();
        assertAll(
                () -> assertEquals(cook.getMap().get(cook.getRecipe("recipe1")),0),
                () -> assertEquals(cook.getMap().get(cook.getRecipe("recipe2")),0)
        );
        cook.addCount("recipe1");
        assertEquals(cook.getMap().get(cook.getRecipe("recipe1")),1);


    }

    @Test
    void deleteFewOrderRecipe(){
        cook.resetFactory();
        cook.setMap();
       for(int i=0;i<10;i++) {
           cook.addCount("recipe1");
       }
      cook.addCount("recipe2");
      cook.deleteFewOrderRecipe();
       assertEquals(cook.getRecipe("recipe2"),null);
       Recipe recipeTest1=new Recipe("recipeTest1");//9.8
       cook.addRecipe(recipeTest1);
       for(int i=0;i<4;i++)
          cook.addCount("recipeTest1");
       cook.deleteFewOrderRecipe();
       assertEquals(cook.getRecipe("recipeTest1"),null);
    }

    @Test
    void getMap(){
        cook.resetFactory();
        cook.setMap();
        assertAll(
                () -> assertTrue(cook.getMap().containsKey(cook.getRecipe("recipe1"))),
                () -> assertTrue(cook.getMap().containsKey(cook.getRecipe("recipe2")))
        );
    }

    @Test
    void getNearbyStores(){

        Store store2 = new Store("store2","address2","8:00","18:00",0.15);
        store2.setPosition(2.0,2.0);
        cook.addStore(store2);
        Store store3 = new Store("store3","address3","8:00","18:00",0.15);
        store3.setPosition(1.5,2.5);
        cook.addStore(store3);
        Store store4 = new Store("store4","address4","8:00","18:00",0.15);
        store4.setPosition(5.0,7.3);
        cook.addStore(store4);
        Store store5 = new Store("store5","address5","8:00","18:00",0.15);
        store5.setPosition(1.0,3.0);
        cook.addStore(store5);
        List<Store> nearbyStores = cook.getNearbyStores(store5);
        assertTrue(nearbyStores.contains(store2));
        assertTrue(nearbyStores.contains(store3));
        assertFalse(nearbyStores.contains(store4));
    }

}