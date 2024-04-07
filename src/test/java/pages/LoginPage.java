package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    @AndroidFindBy(id = "com.hushed.staging:id/signup_button")
    private MobileElement signupButton;

    @AndroidFindBy(id = "com.hushed.staging:id/login_button")
    private MobileElement loginButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement allowButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement secondAllowButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement thirdAllowButton;

    @AndroidFindBy(id = "com.hushed.staging:id/signup_etEmail")
    private MobileElement signUpEmailField;

    @AndroidFindBy(id = "com.hushed.staging:id/signup_etPassword")
    private MobileElement signUpPasswordField;

    @AndroidFindBy(id = "com.hushed.staging:id/login_etEmail")
    private MobileElement emailField;

    @AndroidFindBy(id = "com.hushed.staging:id/login_etPassword")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.hushed.staging:id/login_button")
    private MobileElement secondloginButton;

    @AndroidFindBy(id = "com.hushed.staging:id/signup_button")
    private MobileElement secondSignUputton;

    @AndroidFindBy(id = "com.hushed.staging:id/btnAgree")
    private MobileElement gotItPermissionButton;

    @AndroidFindBy(id = "com.hushed.staging:id/btnAgree")
    private MobileElement secondGotItPermissionButton;

    @AndroidFindBy(id = "com.hushed.staging:id/btnAgree")
    private MobileElement thirdItPermissionButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement audioPermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement locationPermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement phonePermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement mediaPermission;

    @AndroidFindBy(id = "com.hushed.staging:id/btnAgree")
    private MobileElement enableNotificationPermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement secondAllowNotifcationPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Could not log in with this username and password.']")
    private MobileElement loginErrorMessage;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickSignUputton() {
        signupButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterSignUpUsername(String signUpemail) {
        signUpEmailField.sendKeys(signUpemail);
    }

    public void enterSignUpPassword(String signUpPassword) {
        signUpPasswordField.sendKeys(signUpPassword);
    }

    public void enterUsername(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickAllowButton() {
        allowButton.click();
    }

    public void clickSecondSignUpButton() {
        secondSignUputton.click();
    }

    public void clickSecondLoginButton() {
        secondloginButton.click();
    }

    public void acceptAllPermissions() {
        gotItPermissionButton.click();
        audioPermission.click();
        locationPermission.click();
        phonePermission.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(gotItPermissionButton));
        gotItPermissionButton.click();
        secondAllowNotifcationPermission.click();
    }

    public void acceptTheGotItPermission() {
        gotItPermissionButton.click();
        audioPermission.click();
        locationPermission.click();
        phonePermission.click();
    }

    public void acceptTheGotItPermissionForSignUp() {
        gotItPermissionButton.click();
        secondGotItPermissionButton.click();
        audioPermission.click();
        allowButton.click();
        secondAllowButton.click();
        thirdItPermissionButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 45); // Wait for up to 30 seconds
        WebElement thirdAllowButton = wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("com.hushed.staging:id/btnAgree")));
        thirdAllowButton.click();

        // audioPermission.click();
        // locationPermission.click();
        // phonePermission.click();
    }

    public void checkLoginAreItemsAreVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 45); // Wait for up to 30 seconds
        WebElement addNumberBtn = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hushed.staging:id/getNumber")));
        assertTrue(addNumberBtn.isDisplayed());
        WebElement settingsIcon = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hushed.staging:id/headerButtonRight")));
        assertTrue(settingsIcon.isDisplayed());
        WebElement getCreditBtn = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hushed.staging:id/getCredits")));
        assertTrue(getCreditBtn.isDisplayed());
    }

    public void checkLoginErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 30 seconds
        WebElement errorInLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Could not log in with this username and password')]")));
        assertTrue(errorInLogin.isDisplayed());
    }

    public void checkSignUpErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 30 seconds
        WebElement errorInSignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Please enter a valid email address')]")));
        assertTrue(errorInSignUp.isDisplayed());
    }

}
