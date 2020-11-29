Feature: BrandManager

  Background:
    Given A brand manager

  Scenario: Jason wants to add a new recipe
    When Jason wants to add a new recipe, whose name is "recipe3", dough is "Peanut butter", flavour is "Chili", topping is "M&M’s™", mix is "Mixed", cooking is "Chewy"
    Then check the recipe has been added