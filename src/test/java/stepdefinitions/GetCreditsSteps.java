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
import pages.GetCreditsPage;

import java.io.IOException;

public class GetCreditsSteps {

    private LoginPage loginPage;
    private GetCreditsPage getCreditPage;
    private AppiumDriver<MobileElement> driver; // Change to AppiumDriver with MobileElement

    @SuppressWarnings("unchecked")
    @Given("I am on the login screen in Get Credits Steps")
    public void iAmOnTheLoginScreenInGetCreditsSteps() throws Exception {
        driver = StartDriverSession.initializeDriver("Android"); // Make sure this method returns an AppiumDriver
        loginPage = new LoginPage(driver);
        getCreditPage = new GetCreditsPage(driver);
        loginPage.clickLoginButton();

    }

    @When("I enter valid username and password in Get Credits Steps")
    public void iEnterValidUsernameAndPasswordInGetCreditsSteps() throws IOException {
        readProperties readTestData = new readProperties();
        loginPage.enterUsername((String) readTestData.getUsername());
        loginPage.enterPassword((String) readTestData.getPassword());

    }

    @And("I tap the login button in Get Credits Steps")
    public void iTapTheLoginButtonInGetCreditsSteps() {
        loginPage.clickSecondLoginButton();
    }

    @And("I accept all permissions in Get Credits Steps")
    public void iAcceptAllPermissionsInGetCreditsSteps() {
        loginPage.acceptAllPermissions();

    }

    @Then("I should be able to purchase credits successfully")
    public void iShouldBeAbleToPurchaseCreitsSuccessfully() { getCreditPage.clickGetNumberButton();
    }
}
