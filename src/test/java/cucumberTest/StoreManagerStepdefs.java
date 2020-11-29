package cucumberTest;

import cookies.CookieFactory;
import cookies.Order;
import cookies.Store;
import cookies.customer.Member;
import cookies.customer.Tourist;
import cookies.manager.StoreManager;
import cookies.recipe.Recipe;
import io.cucumber.java8.En;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StoreManagerStepdefs implements En {

    Store store1;
    StoreManager storeManager;
    CookieFactory factory;
    Tourist tourist;
    Order order1;
    Member member1;


    public StoreManagerStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("A store of name {string} and with the address {string}, openTime {string}, closeTime {string}, tax {string}",
                (String name, String address, String openTime, String closeTime, String tax) ->
                {
                    double taxVal = Double.valueOf(tax);
                    store1 = new Store(name,address,openTime,closeTime,taxVal);
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
        When("Laura wants to order {int} cookies of {string}, He wants to pick it in {string} at {string}",
                (Integer sum, String recipe, String store, String time) ->
                {
                    Recipe rp = factory.getRecipe(recipe);
                    Map<Recipe, Integer> mp = new HashMap<>();
                    mp.put(rp,sum);
                    DateFormat fmt =new SimpleDateFormat("HH:mm");
                    Date date = fmt.parse(time);
                    store1 = factory.getStore(store);
                    store1.initIngre(50);
                    int way=1;
                    String home="Polytech nice sophia";
                    order1 = member1.creatDiscountOrder(mp,way,date,store1,home);
                });
        Then("check that the store can take the order {string}",
                (String result) -> {
                    boolean res = Boolean.valueOf(result);
                    assertEquals(store1.checkOrder(order1), res);
                });
    }

}