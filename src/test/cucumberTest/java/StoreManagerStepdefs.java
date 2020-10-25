package cucumberTest.java;

import cookies.Store;
import cookies.manager.StoreManager;
import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreManagerStepdefs implements En {

    Store store1;
    StoreManager storeManager;


    public StoreManagerStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("a store of name {string} and with the address {string}, openTime {string}, closeTime {string}",
                (String name, String address, String openTime, String closeTime) ->
                {
                    store1 = new Store(name,address,openTime,closeTime,0.2);
                });
        And("a store manager of name {string}",
                (String nameOfStoreManager)->{
                storeManager = new StoreManager(nameOfStoreManager,store1);
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
    }

}