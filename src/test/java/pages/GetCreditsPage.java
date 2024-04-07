package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GetCreditsPage {

    @AndroidFindBy(id = "com.hushed.staging:id/getCredits")
    private MobileElement getCreditButton;



    private WebDriver driver;

    public GetCreditsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickGetNumberButton() {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.elementToBeClickable(getCreditButton));
        getCreditButton.click();

    }













}
