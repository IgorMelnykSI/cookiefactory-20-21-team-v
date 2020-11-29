package cucumberTest;

import cookies.Store;
import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreStepdefs implements En {

    Store store1;



    public StoreStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("a store of name {string} and with the address {string}, openTime {string}, closeTime {string}, tax {string}",
                (String name, String address, String openHour, String openMin,String closeHour, String closeMin,String tax) ->
                {
                    double taxVal = Double.valueOf(tax);
                    store1 = new Store(name,address,openHour,openMin,closeHour,closeMin,taxVal);
                });

        When("Paule changes working time, the new opening time is {string}: {string}, new closing time is {string}:{string}",
                (String openHour, String openMin,String closeHour,String closeMin) ->
                {
                    store1.setOpenTime(openHour,openMin);
                    store1.setCloseTime(closeHour,closeMin);
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
                    store1.setTax(taxVal);
                });
        Then("Check the actual tax is {string}",
                (String tax) -> {
                    double taxVal = Double.valueOf(tax);
                    assertEquals(store1.getTax(),taxVal,0.01);
                });
    }

}