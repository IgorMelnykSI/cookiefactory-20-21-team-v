Feature: Customer

  Background:
    Given init the factory
    And A customer name "Peter" who join the "Loyalty program"
    And A customer name "Laura" with an account
    And A customer Bob with no account

  Scenario: Bob register an account
    When "Bob" register an account
    Then Bob has an account

  Scenario: Bob make an order of a basic recipe
    When Bob ordered 5 basic recipes named "recipe1"
    Then The order is confirmed

  Scenario: Peter wants to make his first order
    When Peter wants to order 5 cookies of "recipe1", He wants to pick it in "store1" at "16:30"
    Then check the price of the order is "14"

  Scenario: Peter use discount 10% after an order of 30 cookies
    When Peter ordered 30 cookies of "recipe1", picked it in "store1" at "8:30"
    And  he ordered again 5 cookies of "recipe1", pick it in "store1" at "16:30"
    Then check the price of the second order by using discount is "12.6"

  Scenario: Laura join the "Loyalty program"
    When Laura wants to join the "Loyalty program"
    Then check Laura has joined the "Loyalty program"


    Scenario: Peter wants to choose another store
    When the "store" has a technical problem, Peter choose the "polytechStore"
    Then the pickUpStore has been changed to "polytechStore"


    Scenario: Peter wants to choose another store
      When the "store" has many orders chosen at the same time , Peter choose the "polytechStore"
      Then the pickUpStore has been changed to "polytechStore"

    Scenario: Peter wants to choose another store
      When the "store" that he has chosen lacks ingredients , Peter choose the "polytechStore"
      Then the pickUpStore has been changed to "polytechStore"


    Scenario: Peter wants to change the way from picking up to a delivery
      When Peter changes the way from picking up to a delivery
      Then  The order is finished and check the delivery fee is 6

    Scenario: Bob wants to pick his order in store.
     When Bob reached the time of order he selected
     Then Bob picked up his order successfully

