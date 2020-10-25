Feature: Store Manager

  Background:
    Given a store of name "store1" and with the address "Biot", openTime "8:30", closeTime "18:00"
    And a store manager of name "Paule"

  Scenario: Paule can change the opening hours
    When Paule changes working time, the new opening time is "8:00", new closing time is "22:00"
    Then Check the actual working time is now from "8:00" to "22:00"
