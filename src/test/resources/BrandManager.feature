Feature: BrandManager

  Background:
    Given A brand manager named "Jason"

  Scenario: Jason adds a new recipe
    When Jason wants to add a new recipe, whose name is "recipe3", dough is "Peanut butter", flavour is "Chili", topping is "M&M’s™", mix is "Mixed", cooking is "Chewy"
    Then check the recipe has been added

  Scenario: Jason deletes a recipe
    When Jason wants to delete  a recipe not ordered by many people
    Then check the recipe has been deleted
