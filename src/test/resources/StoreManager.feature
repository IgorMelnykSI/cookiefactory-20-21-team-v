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