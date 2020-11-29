package cucumberTest;

import cookies.CookieFactory;
import cookies.CookieItem;
import cookies.Order;
import cookies.Store;
import cookies.customer.Member;
import cookies.recipe.Recipe;
import io.cucumber.java8.En;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreStepdefs implements En {

    Store store1;
    CookieFactory factory;
    Order order1;
    Member member1;



    public StoreStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("a store of name {string} and with the address {string}, openTime {string}, closeTime {string}, tax {string}",
                (String name, String address, String openHour, String openMin,String closeHour, String closeMin,String tax) ->
                {
                    double taxVal = Double.valueOf(tax);
                    store1 = new Store(name,address,openHour,openMin,closeHour,closeMin,taxVal);
                });
        And("init the factory",
                () ->
                {
                    factory = new CookieFactory();
                });

        When("The store changes working time, the new opening time is {string}: {string}, new closing time is {string}:{string}",
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
        When("The tax of the store is changed, the new tax is {string}",
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
        When("The situation of the store has changed, it {string}ly has a problem",
                (String i) ->
                {
                    boolean hasProblem = Boolean.valueOf(i);
                    store1.setHasProblem(hasProblem);
                });
        Then("Check if the store {string}ly has a problem",
                (String i) -> {
                    boolean taxVal = Boolean.valueOf(i);
                    assertEquals(store1.hasProblem(),i);
                });
        When("A member wants to order {int} cookies of {string}, He wants to pick it in {string} at {string}",
                (Integer sum, String recipe, String store, String time) ->
                {
                    Recipe rp = factory.getRecipe(recipe);
                    Map<Recipe, Integer> mp = new HashMap<>();
                    mp.put(rp,sum);
                    DateFormat fmt =new SimpleDateFormat("HH:mm");
                    Date date = fmt.parse(time);
                    Store s = factory.getStore(store);
                    s.initIngre(50);
                    int way=1;
                    String home="Polytech nice sophia";
                    order1 = member1.creatDiscountOrder(mp,way,date,s,home);
                });
        Then("check that the store can take the order {string}",
                (String result) -> {
                    boolean res = Boolean.valueOf(result);
                    assertEquals(store1.checkOrder(order1), res);
                });
    }

}