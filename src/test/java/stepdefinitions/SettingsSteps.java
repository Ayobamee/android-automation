package stepdefinitions;

import filereader.readProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.SessionManager.StartDriverSession;
import pages.LoginPage;
import pages.MainMenuPage;
import java.io.IOException;

public class SettingsSteps {

    private LoginPage loginPage;
    private MainMenuPage mainMenuPage;
    private AndroidDriver<AndroidElement> driver;

    @SuppressWarnings("unchecked")
    @Given("I am on the login screen in Settings Steps")
    public void iAmOnTheLoginScreenInSettingsSteps() throws Exception {

        driver = (AndroidDriver<AndroidElement>) StartDriverSession.initializeDriver("Android"); // Make sure this
                                                                                                 // method returns an
                                                                                                 // AppiumDriver
        loginPage = new LoginPage(driver);
        mainMenuPage = new MainMenuPage(driver); // Initialize here, after driver is instantiated
        loginPage.clickLoginButton();

    }

    @When("I enter valid username and password in Settings Steps")
    public void iEnterValidUsernameAndPasswordInSettingsSteps() throws IOException {
        readProperties readTestData = new readProperties();
        loginPage.enterUsername((String) readTestData.getUsername());
        loginPage.enterPassword((String) readTestData.getPassword());

    }

    @And("I tap the login button in Settings Steps")
    public void iTapTheLoginButtonInSettingsSteps() {
        loginPage.clickSecondLoginButton();
    }

    @And("I accept all permissions in Settings Steps")
    public void iAcceptAllPermissionsInSettingsSteps() {
        loginPage.acceptAllPermissions();

    }

    @And("I should be logged in successfully in Settings Steps")
    public void iShouldBeLoggedInSuccessfullyInSettingsSteps() {
        loginPage.checkLoginAreItemsAreVisible();
    }

    @And("I click Settings from the Main Menu")
    public void iClickSettings() {
        mainMenuPage.clickSettingsTag();
    }

    @Then("I should see settings items in the App Settings")
    public void iSeeSettingsItemsinAppSettings() {
        mainMenuPage.viewItemsInSettings();
    }
}
