package cucumberTest;

import cookies.CookieFactory;
import cookies.Order;
import cookies.Store;
import cookies.customer.Tourist;
import cookies.manager.StoreManager;
import cookies.recipe.Recipe;
import io.cucumber.java8.En;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StoreManagerStepdefs implements En {

    Store store1;
    StoreManager storeManager;
    CookieFactory factory = new CookieFactory();
    Tourist tourist;
    Order order1;
    Order[] orders = new Order[30];

    public StoreManagerStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("A store of name {string} and with the address {string}, openTime {string}, closeTime {string}, tax {string}",
                (String name, String address, String openTime, String closeTime, String tax) ->
                {
                    double taxVal = Double.valueOf(tax);
                    store1 = new Store(name,address,openTime,closeTime,taxVal);
                    store1.initIngre(50);
                });
        And("A store manager of name {string} who manage store1",
                (String nameOfStoreManager)->{
                    storeManager = new StoreManager(nameOfStoreManager,store1);
                });
        And("A customer named Laura",
                ()->{
                    tourist = new Tourist();
                });
        When("Paule changes working time, the new opening time is {string}, new closing time is {string}",
                (String openTime, String closeTime) ->
                {
                    storeManager.changeOpenTime(openTime);
                    storeManager.changeCloseTime(closeTime);
                });
        Then("Check the actual working time is now from {string} to {string}",
                (String openTime, String closeTime) -> {
                    assertEquals(store1.getOpenTime(),openTime);
                    assertEquals(store1.getCloseTime(),closeTime);
                });
        When("Paule changes the tax of the store, the new tax is {string}",
                (String tax) ->
                {
                    double taxVal = Double.valueOf(tax);
                    storeManager.changeTax(taxVal);
                });
        Then("Check the actual tax is {string}",
                (String tax) -> {
                    double taxVal = Double.valueOf(tax);
                    assertEquals(store1.getTax(),taxVal,0.01);
                });
        When("Laura ordered her personnel recipe named {string}\\(dough:{string}, flavour: {string}, topping: {string}, mix: {string}, cooking: {string})",
        (String name,String dough, String flavour, String topping, String mix, String cooking) -> {
            tourist.createPrivateRecipe(name,cooking,dough,flavour,mix,topping);
        });
        Then("Check the actual price is {string}, isn't {string}",
                (String actualPrice, String originalPrice) -> {
                    double actualPriceVal = Double.valueOf(actualPrice);
                    double originalPriceVal = Double.valueOf(originalPrice);
                    assertEquals(tourist.getPrivateRecipes().get(0).getPrice(),actualPriceVal,0.01);
                    assertNotEquals(tourist.getPrivateRecipes().get(0).getPrice(),originalPriceVal,0.01);
        });
        When("Store1 lack the ingredient {string}, only {int}",
        (String ingredientName, Integer quantity) -> {
            store1.modifyIngredientQuantity(factory.getIngredient(ingredientName),quantity);
        });
        Then("Paule adds {int} {string}",
        (Integer quantity, String ingredientName) -> {
            store1.addIngredientQuantity(factory.getIngredient(ingredientName),quantity);
        });
        Then("Check the quantity of {string} is {int}",
        (String ingredientName, Integer quantity) -> {
            assertEquals(store1.getIngredientQuantity(factory.getIngredient(ingredientName)),quantity);
        });
        When("Laura order {int} cookies of {string}, she want to pick it in store1 at {string}",
                (Integer sum, String recipe, String time) ->
                {
                    Recipe rp = factory.getRecipe(recipe);
                    Map<Recipe, Integer> mp = new HashMap<>();
                    mp.put(rp,sum);
                    DateFormat fmt =new SimpleDateFormat("HH:mm");
                    Date date = fmt.parse(time);
                    int way=1;
                    String home="Polytech nice sophia";
                    order1 = tourist.creatNoDiscountOrder(mp,way,date,store1,home);
                });
        Then("Paule confirm the order as achievable",
                () -> {
                    assertTrue(store1.checkOrder(order1));
                });

        When("^Laura changes the way from picking up to a delivery$", () -> {
            Recipe rp = factory.getRecipesList().get(0);
            Map<Recipe, Integer> mp = new HashMap<>();
            mp.put(rp,5);
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse("2021-12-01 17:36:01");
            store1 = new Store("store1","address1","8:30","19:00",0.2);
            store1.initIngre(50);
            int way=1;
            String home="Polytech nice sophia";
            order1 = new Order(mp,way,date,store1,home);
            order1.caculatePrice();
            order1.changePickToDelivery("2020-12-01 17:36:01");

        });
        Then("^Paule contact MarcelEat and increase (\\d+)% of delivery fee$", (Integer arg0) -> {
            storeManager.contactMarcelEat(order1);
        });
        Then("^Check the delivery fee is (\\d+),and the order is finished$", (Integer arg0) -> {
            assertEquals(6,order1.getPrice()-2.8*5);
            assertEquals("Finished",order1.getState().handle(order1));
        });

        When("^The \"([^\"]*)\" was ordered the most times over (\\d+) days$", (String recipe, Integer arg1) -> {
            Recipe rp = factory.getRecipe(recipe);
            Map<Recipe, Integer> mp = new HashMap<>();
            mp.put(rp,5);
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = fmt.parse("2020-11-10 17:36:00");
            Date date2 = fmt.parse("2020-11-11 17:36:00");
            Date date3 = fmt.parse("2020-11-12 17:36:00");
            int way=1;
            String home="Polytech nice sophia";
            for(int i = 0; i < 9; i++)
                orders[i]= tourist.creatNoDiscountOrder(mp,way,date1,store1,home);
            for(int i = 9; i < 22; i++)
                orders[i]= tourist.creatNoDiscountOrder(mp,way,date2,store1,home);
            for(int i = 22; i < 30; i++)
                orders[i]= tourist.creatNoDiscountOrder(mp,way,date3,store1,home);

        });
        Then("^Check the \"([^\"]*)\" is the bestof$", (String arg0) -> {
            assertEquals("recipe1",store1.getMyBestOf().getName());
        });


    }

}