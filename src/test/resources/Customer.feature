Feature: Customer

  Background:
    Given init the factory
    And A customer name "Peter" who join the "Loyalty program" and have the discount de 10%

  Scenario: Peter wants to make an order
    When Peter wants to order 5 cookies of "recipe1", He wants to pick it in "store1" at "16:30"
    Then check the price of the order is "12.5"

  Scenario: Peter wants to make an order with discount 10%
    When Peter wants to order 5 cookies of "recipe1", He wants to pick it in "store1" at "16:30", and He wants to use the discount de 10% by "Loyalty program"
    Then check the price of the order by using discount is "11.25"
