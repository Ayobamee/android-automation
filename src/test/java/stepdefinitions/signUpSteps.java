package stepdefinitions;

import io.appium.java_client.android.AndroidElement;
import java.security.SecureRandom;
import org.SessionManager.StartDriverSession;
import pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import java.io.IOException;
import filereader.readProperties;

public class signUpSteps {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomEmail(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        sb.append("@affinityclick.com"); // You can change the domain as needed
        return sb.toString();
    }

    private LoginPage loginPage;
    private AndroidDriver<AndroidElement> driver;

    @Given("I am on the login-signup screen")
    public void iAmOnTheLoginSignUpScreen() throws Exception {

        @SuppressWarnings("rawtypes")
        AppiumDriver driver = StartDriverSession.initializeDriver("Android");
        loginPage = new LoginPage(driver);
        loginPage.clickSignUputton();

    }

    @When("I enter valid username and password combination on the login-signup screen")
    public void iEnterValidUsernameAndPasswordOfTheApp() throws IOException {
        String randomEmail = generateRandomEmail(6);
        readProperties readTestData = new readProperties();
        loginPage.enterSignUpUsername(randomEmail);
        loginPage.enterSignUpPassword((String) readTestData.getPassword());
    }

    @And("I tap the second sign up button on the login-signup screen")
    public void iTapTheSecondSignupButton() {
        loginPage.clickSecondSignUpButton();
    }

    @And("I accept all permissions on the login-signup screen")
    public void iAcceptAllPermissionsForSignUp() {
        loginPage.acceptTheGotItPermissionForSignUp();
    }

    // @Then("I should see an error stating I provided a wrong email address")
    // public void iShouldSeeASignUpError() {
    // loginPage.checkSignUpErrorMessage();
    // }

}
