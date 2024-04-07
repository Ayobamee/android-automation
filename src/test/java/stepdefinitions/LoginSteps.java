package stepdefinitions;

import io.appium.java_client.android.AndroidElement;

import org.SessionManager.StartDriverSession;
import pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import java.io.IOException;
import filereader.readProperties;

public class LoginSteps {

    private LoginPage loginPage;
    private AndroidDriver<AndroidElement> driver;

    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() throws Exception {

        @SuppressWarnings("rawtypes")
        AppiumDriver driver = StartDriverSession.initializeDriver("Android");
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() throws IOException {
        readProperties readTestData = new readProperties();
        loginPage.enterUsername((String) readTestData.getUsername());
        loginPage.enterPassword((String) readTestData.getPassword());

    }

    @And("I tap the login button")
    public void iTapTheLoginButton() {
        loginPage.clickSecondLoginButton();
    }

    @And("I accept all permissions")
    public void iAcceptAllPermissions() {
        loginPage.acceptAllPermissions();

    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        loginPage.checkLoginAreItemsAreVisible();
    }
}
