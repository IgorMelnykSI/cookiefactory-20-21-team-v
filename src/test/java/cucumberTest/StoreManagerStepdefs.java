package cucumberTest;

import cookies.CookieFactory;
import cookies.Store;
import cookies.customer.Tourist;
import cookies.manager.StoreManager;
import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StoreManagerStepdefs implements En {

    Store store1;
    StoreManager storeManager;
    CookieFactory factory;
    Tourist tourist;

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
    }

}