Feature: Shopping automation
  Scenario: Testing shopping as guest
    Given I go to ebays website
    When I search for product
    And I click on the first result
    And I set the item quantity and click buy now
    And I click checkout as guest and provide billing details
    Then I validate that items was added to cart and shop was succesfull

