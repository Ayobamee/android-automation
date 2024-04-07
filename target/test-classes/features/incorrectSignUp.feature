Feature: Incorrect Sign up to the app

  As a user
  I want to enter incorrect sign up details into the app during a sign up process
  So that I cannot create an account

  Scenario: Validate user cannot signup to the app with invalid sign up credentials
    Given I am on the signup screen
    When I enter invalid username and password combination for the signUp step
    And I tap the second signUp button
    Then I should see an error stating I provided a wrong email address

