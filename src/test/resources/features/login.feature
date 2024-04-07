Feature: Login to the app

  As a user
  I want to log into the app
  So that I can access my account

  Scenario: Validate user can login with valid login credentials
    Given I am on the login screen
    When I enter valid username and password
    And I tap the login button
    And I accept all permissions
    Then I should be logged in successfully
