package cucumberTest;
import com.sun.source.tree.AssertTree;
import cookies.CookieFactory;
import cookies.Order;
import cookies.Store;
import cookies.customer.Member;
import cookies.customer.Tourist;
import cookies.recipe.Recipe;
import io.cucumber.java8.En;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerStepdefs implements En {

    CookieFactory factory;
    Member member1;
    Member member2;
    Tourist tourist1;
    Tourist tourist2;
    Order order1;
    Order order2;
    Order order3;
    Order order4;
    private Store store;
    private Date date;
    private int way;
    private String home;

    public CustomerStepdefs() { // implementation des steps dans le constructeur (aussi possible dans des méthodes)
        Given("init the factory",
                () ->
                {
                    factory = new CookieFactory();
                });
        And("A customer name {string} who join the \"Loyalty program\"",
                (String name)->{
                    member1 = new Member(name,true);
                });
        And("A customer name {string} with an account",
                (String name)->{
                    member2 = new Member(name);
                });
        And("A customer Bob with no account",
                ()->{
                    tourist1 = new Tourist();
                });
        And("A customer Sam with no account",
                ()->{
                    tourist2 = new Tourist();
                });
        When("{string} wants to register a member account",
                (String name)->{
                    tourist1 = new Member(name);
                });
        Then("{string} has a member account",
                (String name) -> {
                    Member tmp = (Member)tourist1;
                    assertTrue(name.equals(tmp.getName()));
                });
        When("Sam wants to make an order of a basic recipe",
                ()->{
                    Recipe recipe = factory.getRecipesList().get(0);
                    Map<Recipe,Integer> mp = new HashMap<>();
                    date = new Date();
                    GregorianCalendar gc = new GregorianCalendar();
                    gc.set(Calendar.YEAR,2020);
                    gc.set(Calendar.MONTH, 11);
                    gc.set(Calendar.DAY_OF_MONTH, 2);
                    date = gc.getTime();
                    way=1;
                    home="polytech nice sophia";
                    store = new Store("store1","Antibes","8:00","16:00",0.15);
                    store.initIngre(30);
                    mp.put(recipe,10);
                    order4 = tourist2.creatNoDiscountOrder(mp,way,date,store,home);
                });
        Then("Sam made an order of a basic recipe",
                () -> {
                    Map<Recipe,Integer> recipes=new HashMap<>();
                    recipes = order4.getRecipes();
                    assertTrue(factory.getRecipesList().get(0).compareRecipe((Recipe) recipes.keySet().toArray()[0]));
                });
        When("Peter wants to order {int} cookies of {string}, He wants to pick it in {string} at {string}",
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
        Then("check the price of the order is {string}",
                (String price) -> {
                    double val = Double.valueOf(price);
                    assertEquals(order1.getPrice(), val);
                });
        When("Peter ordered {int} cookies of {string}, picked it in {string} at {string}",
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
                    order2 = member1.creatDiscountOrder(mp,way,date,s,home);
                });
        And("he ordered again {int} cookies of {string}, pick it in {string} at {string}",
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
                    order3 = member1.creatDiscountOrder(mp,way,date,s,home);

                });
        Then("check the price of the second order by using discount is {string}",
                (String price) -> {
                    double val = Double.valueOf(price);
                    assertEquals(order3.getPrice(), val);
                });
        When("Laura wants to join the \"Loyalty program\"",
                () ->
                {
                    member2.setLoyal(true);
                });
        Then("check Laura has joined the \"Loyalty program\"",
                () -> {
                    assertEquals(member2.isLoyal(), true);
                });
    }

}
