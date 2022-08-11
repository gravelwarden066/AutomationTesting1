@AuthPage
Feature: Customer navigates to the Landing Page performs LogIn action

  Scenario Outline: Customer Logs In with a valid account
    Given Navigate to the Landing Page
    When I enter username <username> and password <password>
    And The user clicks on LogIn button
    Then User is able to access the Home Page
    Examples:
      | username             | password     |
      | standard_user        | secret_sauce |

  Scenario Outline: Customer Logs In with a invalid account
    Given Navigate to the Landing Page
    When I enter username <username> and password <password>
    And The user clicks on LogIn button
    Then User should see an error <error> message
    Examples:
      | username        | password         | error                                                                     |
      | invalid_user    | invalid_password | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | invalid_password | Epic sadface: Username and password do not match any user in this service |
      | invalid_user    | secret_sauce     | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce     | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   |                  | Epic sadface: Password is required                                        |
      |                 | secret_sauce     | Epic sadface: Username is required                                        |
