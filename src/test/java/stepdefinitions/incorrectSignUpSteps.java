package stepdefinitions;

import io.appium.java_client.android.AndroidElement;

import org.SessionManager.StartDriverSession;
import pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import java.io.IOException;
import filereader.readProperties;

public class incorrectSignUpSteps {

    private LoginPage loginPage;
    private AndroidDriver<AndroidElement> driver;

    @Given("I am on the signup screen")
    public void iAmOnTheSignUpScreen() throws Exception {

        @SuppressWarnings("rawtypes")
        AppiumDriver driver = StartDriverSession.initializeDriver("Android");
        loginPage = new LoginPage(driver);
        loginPage.clickSignUputton();

    }

    @When("I enter invalid username and password combination for the signUp step")
    public void iEnterInvalidUsernameAndPasswordOfTheApp() throws IOException {
        readProperties readTestData = new readProperties();
        loginPage.enterSignUpUsername((String) readTestData.getIncorrectSignUpUsername());
        loginPage.enterSignUpPassword((String) readTestData.getIncorrectPassword());
    }

    @And("I tap the second signUp button")
    public void iTapTheSecondSignUpButton() {
        loginPage.clickSecondSignUpButton();
    }

    @Then("I should see an error stating I provided a wrong email address")
    public void iShouldSeeASignUpError() {
        loginPage.checkSignUpErrorMessage();
    }

}
