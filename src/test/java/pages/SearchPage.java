package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement dots;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title']")
    MobileElement buttonLogin;

    public SearchPage clickDots(){
        click(dots);
        return this;
    }

    public LoginPage clickLogin(){
        click(buttonLogin);
        return new LoginPage(driver);
    }

}
