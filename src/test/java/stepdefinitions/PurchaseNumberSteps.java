package stepdefinitions;

import filereader.readProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.SessionManager.StartDriverSession;
import pages.LoginPage;
import pages.PurchaseNumberPage;

import java.io.IOException;

public class PurchaseNumberSteps {

    private LoginPage loginPage;
    private PurchaseNumberPage purchaseNumberPage;
    private AppiumDriver<MobileElement> driver; // Change to AppiumDriver with MobileElement

    @SuppressWarnings("unchecked")
    @Given("I am on the login screen in Purchase Number Steps")
    public void iAmOnTheLoginScreenInPurchaseNumberSteps() throws Exception {
        driver = StartDriverSession.initializeDriver("Android"); // Make sure this method returns an AppiumDriver
        loginPage = new LoginPage(driver);
        purchaseNumberPage = new PurchaseNumberPage(driver); // Initialize here, after driver is instantiated
        loginPage.clickLoginButton();

    }

    @When("I enter valid username and password in Purchase Number Steps")
    public void iEnterValidUsernameAndPasswordInPurchaseNumberSteps() throws IOException {
        readProperties readTestData = new readProperties();
        loginPage.enterUsername((String) readTestData.getUsername());
        loginPage.enterPassword((String) readTestData.getPassword());

    }

    @And("I tap the login button in Purchase Number Steps")
    public void iTapTheLoginButtonInPurchaseNumberSteps() {
        loginPage.clickSecondLoginButton();
    }

    @And("I accept all permissions in Purchase Number Steps")
    public void iAcceptAllPermissions() {
        loginPage.acceptAllPermissions();

    }

    @Then("I should be able to purchase a number successfully")
    public void iShouldBeAbleToPurchaseANumberSuccessfully() {
        purchaseNumberPage.clickAddNumberButton();
    }
}
