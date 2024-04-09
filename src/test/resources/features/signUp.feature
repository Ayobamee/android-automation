Feature: Sign up to the app

  As a user
  I want to enter correct sign up details into the app during a sign up process
  So that I can create an account

  Scenario: Validate user can signup to the app with valid sign up credentials
    Given I am on the login-signup screen
    When I enter valid username and password combination on the login-signup screen
# And I tap the second sign up button on the login-signup screen
# And I accept all permissions on the login-signup screen
# Then I should see an error stating I provided a wrong email address

