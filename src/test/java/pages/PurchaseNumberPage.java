package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.messages.Messages.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PurchaseNumberPage {

    @AndroidFindBy(id = "com.hushed.staging:id/getNumber")
    private MobileElement addNumberButton;


    private WebDriver driver;

    public PurchaseNumberPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickAddNumberButton() {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.elementToBeClickable(addNumberButton));
        addNumberButton.click();

    }













}
