Feature: Purchase number

  As a user
  I want to log into the app
  So that I can purchase a number successfully

Scenario: Validate user can purchase a number successfully
  Given I am on the login screen in Purchase Number Steps
 When I enter valid username and password in Purchase Number Steps
 And I tap the login button in Purchase Number Steps
 And I accept all permissions in Purchase Number Steps
 Then I should be able to purchase a number successfully
