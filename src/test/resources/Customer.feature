Feature: Customer

  Background:
    Given init the factory
    And A customer name "Peter" who join the "Loyalty program"
    And A customer name "Laura" with an account

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