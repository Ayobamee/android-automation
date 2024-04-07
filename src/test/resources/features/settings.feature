Feature: Access Settings from Main Menu

  As a user
  I want to log into the app
  So that I can access my settings menu

  Scenario: Validate user can navigate to Settings from Main Menu
    Given I am on the login screen in Settings Steps
    When I enter valid username and password in Settings Steps
    And I tap the login button in Settings Steps
    And I accept all permissions in Settings Steps
    And I should be logged in successfully in Settings Steps
    And I click Settings from the Main Menu
