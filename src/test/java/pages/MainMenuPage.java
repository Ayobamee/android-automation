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

public class MainMenuPage {

    @AndroidFindBy(id = "com.hushed.staging:id/headerButtonRight")
    private MobileElement settingsTag;

    private WebDriver driver;

    public MainMenuPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickSettingsTag() {

        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 30 seconds
        WebElement settingsBtn = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.hushed.staging:id/headerButtonRight")));
        settingsBtn.click();

    }

    public void viewItemsInSettings() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement helpFeedbackTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Help & Feedback')]")));
        assertTrue(helpFeedbackTxt.isDisplayed());

        WebDriverWait secondWait = new WebDriverWait(driver, 10);
        WebElement accountTxt = secondWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Account')]")));
        assertTrue(accountTxt.isDisplayed());

        WebDriverWait thirdWait = new WebDriverWait(driver, 10);
        WebElement notificationsTxt = thirdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Notifications')]")));
        assertTrue(notificationsTxt.isDisplayed());

        WebDriverWait fourthWait = new WebDriverWait(driver, 10);
        WebElement deviceSoundTxt = fourthWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Device & Sounds')]")));
        assertTrue(deviceSoundTxt.isDisplayed());

        WebDriverWait fifthWait = new WebDriverWait(driver, 10);
        WebElement versionUpdatesTxt = fifthWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.TextView[contains(@text, 'Version & Updates')]")));
        assertTrue(versionUpdatesTxt.isDisplayed());

    }

}
