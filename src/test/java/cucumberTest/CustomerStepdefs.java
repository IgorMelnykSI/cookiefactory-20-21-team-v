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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

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
    private Store store1;
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
        When("Sam wants to make an order of a basic recipe {string}",
                (String r)->{
                    Recipe recipe = factory.getRecipe(r);;
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
        Then("Sam made an order of a basic recipe {string}",
                (String r) -> {
                    Map<Recipe,Integer> recipes=new HashMap<>();
                    recipes = order4.getRecipes();
                    assertTrue(factory.getRecipe(r).compareRecipe((Recipe) recipes.keySet().toArray()[0]));
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
        When("^the \"([^\"]*)\" has a technical problem, Peter choose the \"([^\"]*)\"$",
                (String store, String store1) ->
                {
                    this.store = new Store(store,"Antibes","8:00","16:00",0.15);
                    this.store.setHasProblem(true);
                    this.store.initIngre(50);
                    this.store.setPosition(11.0,3.0);
                    this.store1 = new Store(store1,"Antibes","8:00","16:00",0.15);
                    this.store1.initIngre(50);
                    this.store1.setPosition(11.0,2.0);
                    factory.addStore(this.store);
                    factory.addStore(this.store1);

                    Recipe recipe = factory.getRecipe("recipe1");;
                    Map<Recipe,Integer> mp = new HashMap<>();
                    date = new Date();
                    GregorianCalendar gc = new GregorianCalendar();
                    gc.set(Calendar.YEAR,2020);
                    gc.set(Calendar.MONTH, 11);
                    gc.set(Calendar.DAY_OF_MONTH, 2);
                    date = gc.getTime();
                    way=1;
                    home="polytech nice sophia";
                    mp.put(recipe,10);

                    if(this.store.hasProblem()){
                        order1 = tourist2.creatNoDiscountOrder(mp,way,date,this.store1,home);
                    }


                });
        Then("^the pickUpStore has been changed to \"([^\"]*)\"$",
                ( String store1) -> {
                    assertEquals("polytechStore",order1.getPickUpStore().getName());
                });
        When("^the \"([^\"]*)\" has many orders chosen at the same time , Peter choose the \"([^\"]*)\"$",
                (String store, String store1) -> {

                    Recipe recipe = factory.getRecipe("recipe1");;
                    Map<Recipe,Integer> mp = new HashMap<>();
                    date = new Date();
                    GregorianCalendar gc = new GregorianCalendar();
                    mp.put(recipe,10);
                    gc.set(2020,Calendar.DECEMBER, 1,18,30);
                    Order[] order = new Order[30];
                    date = gc.getTime();
                    way=1;
                    home="polytech nice sophia";
                    this.store = new Store(store,"Antibes","8:00","16:00",0.15);
                    this.store.initIngre(50);
                    this.store.setPosition(11.0,3.0);
                    this.store1 = new Store(store1,"Antibes","8:00","16:00",0.15);
                    this.store1.initIngre(50);
                    this.store1.setPosition(11.0,2.0);
                    factory.addStore(this.store);
                    factory.addStore(this.store1);

                    for(int i = 0; i < 30 ; i++){
                        order[i] = new Order();
                        order[i].setPickUpStore(this.store);
                        order[i].setPickUpDate(date);
                        this.store.saveOrder(order[i]);
                    }

                    if(this.store.isBusy(date)){
                        order1 = tourist2.creatNoDiscountOrder(mp,way,date,this.store1,home);
                    }
        });

    }

}
