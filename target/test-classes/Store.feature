Feature: is the new openHour set?
#
Scenario: it is set
    Given the openHour of monday is changed
    When I ask the open hour of monday
    Then I will be given the new open hour