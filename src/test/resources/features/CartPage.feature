@CartPage
Feature: User navigates to the Cart Page and interacts with it

  Scenario Outline: User adds a product to cart and then deletes it
    Given User navigates to the Home Page
    When User adds to cart product <product>
    And User navigates to the Cart Page
    And User removes a specific product<product> by clicking Remove Button
    Then User should no longer see the deleted product<product> in the shopping cart
    Examples:
      | product             |
      | Sauce Labs Backpack |


  @TestURL
    Scenario: Testing URL
    Given User go to page


  @FullFlowTest
  Scenario Outline: User performs an order
    Given User navigates to the Home Page
    When User adds to cart product <product>
    And User navigates to the Cart Page
    And User clicks on Checkout button
    And User fills CheckOut Form with his/her first name<first_name> , last name<last_name> and zip code<zip_code>
    And User clicks on Continue button
    And User clicks Finish button
    Then User should see the Order Confirmation Page
    Examples:
      | product                 | first_name | last_name | zip_code |
      | Sauce Labs Bolt T-Shirt | Michael    | Myers     | 012345   |