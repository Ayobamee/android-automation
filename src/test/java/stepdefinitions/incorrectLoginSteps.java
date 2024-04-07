package stepdefinitions;

import filereader.readProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.SessionManager.StartDriverSession;
import pages.LoginPage;

import java.io.IOException;

public class incorrectLoginSteps {

    private LoginPage loginPage;
    private AndroidDriver<AndroidElement> driver;

    @Given("I am on the login screen of the app")
    public void iAmOnTheLoginScreenOfTheApp() throws Exception {

        @SuppressWarnings("rawtypes")
        AppiumDriver driver = StartDriverSession.initializeDriver("Android");
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

    }

    @When("I enter valid username and password on the app")
    public void iEnterValidUsernameAndPasswordOfTheApp() throws IOException {
        readProperties readTestData = new readProperties();
        loginPage.enterUsername((String) readTestData.getIncorrectUsername());
        loginPage.enterPassword((String) readTestData.getPassword());

    }

    @And("I tap the login button on the app")
    public void iTapTheLoginButtonOfTheApp() {
        loginPage.clickSecondLoginButton();
    }

    @And("I accept the got it permission")
    public void iAcceptTheGotItPermissions() {
        loginPage.acceptTheGotItPermission();

    }

    @Then("I should be not be logged in successfully")
    public void iShouldNotBeLoggedInSuccessfully() {
        loginPage.checkLoginErrorMessage();
    }
}
