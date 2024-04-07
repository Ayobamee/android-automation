Feature: Get credits

  As a user
  I want to log into the app
  So that I can purchase credits successfully

  Scenario: Validate user can purchase credits successfully
    Given I am on the login screen in Get Credits Steps
    When I enter valid username and password in Get Credits Steps
    And I tap the login button in Get Credits Steps
    And I accept all permissions in Get Credits Steps
    Then I should be able to purchase credits successfully
