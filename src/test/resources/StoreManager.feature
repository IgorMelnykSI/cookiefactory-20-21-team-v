Feature: Store Manager

  Background:
    Given A store of name "store1" and with the address "Biot", openTime "8:30", closeTime "18:00", tax "0.2"
    And A store manager of name "Paule" who manage store1
    And A customer named Laura

  Scenario: Paule can change the opening hours
    When Paule changes working time, the new opening time is "8:00", new closing time is "22:00"
    Then Check the actual working time is now from "8:00" to "22:00"

  Scenario: Paule can change the tax
    When Paule changes the tax of the store, the new tax is "0.18"
    Then Check the actual tax is "0.18"

  Scenario: Laura ordered her personnel recipe, the price is increased 25%
    When Laura ordered her personnel recipe named "myRecipe1"(dough:"Plain", flavour: "Vanilla", topping: "White chocolate and Milk chocolate", mix: "Mixed", cooking: "Crunchy")
    Then Check the actual price is "3.75", isn't "3.00"

  Scenario: Paule adds a kind of ingredients
    When Store1 lack the ingredient "White chocolate", only 10
    Then Paule adds 100 "White chocolate"
    Then Check the quantity of "White chocolate" is 110

  Scenario: Paule confirm the order ordered by Laura
    When Laura order 5 cookies of "recipe1", she want to pick it in store1 at "8:30"
    Then Paule confirm the order as achievable

  Scenario: Paule has received request that the customer want to change the way from picking up to a delivery
    When Laura changes the way from picking up to a delivery
    Then Paule contact MarcelEat and increase 50% of delivery fee
    Then Check the delivery fee is 6,and the order is finished

























    
