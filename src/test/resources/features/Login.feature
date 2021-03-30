Feature: Sauce Lab Login
  Scenario: Valid Login
    Given I am on the login page
    When  I enter valid username
    And   I enter valid password
    And   I click on the login button
    Then  I see the home page


