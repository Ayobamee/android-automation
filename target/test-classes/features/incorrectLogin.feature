Feature: Inability to Login to the app

  As a user
  I want to enter invalid login credentials during a login process
  So that I cannot access my account

  Scenario: Validate user cannot login to the app with invalid login credentials
    Given I am on the login screen of the app
    When I enter valid username and password on the app
    And I tap the login button on the app
    And I accept the got it permission
    Then I should be not be logged in successfully
