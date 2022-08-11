@HomePage
Feature: User navigates to the Home Page and interacts with it

  Scenario Outline: User clicks on a specific product
    Given User navigates to the Home Page
    When User clicks on a specific product <product>
#    Then User should be on selected product page
    Examples:
      | product                           |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario Outline: User adds Backpack and Bolt T-shirt to the shopping cart
    Given User navigates to the Home Page
    And User adds to cart product <product1>
    And User adds to cart product <product2>
    Then User navigates to the Shopping Cart and should see product1 <product1> and product2 <product2>
    Examples:
      | product1            | product2                |
      | Sauce Labs Backpack | Sauce Labs Bolt T-Shirt |

  Scenario: User clicks on Twitter Button
    Given User navigates to the Home Page
    When User clicks on Twitter button
#    Then User should be on Twitter page

  Scenario: User clicks on Facebook Button
    Given User navigates to the Home Page
    When User clicks on Facebook button
#    Then User should be on Twitter page

  Scenario: User clicks on LinkedIn Button
    Given User navigates to the Home Page
    When User clicks on LinkedIn button
#    Then User should be on Twitter page

