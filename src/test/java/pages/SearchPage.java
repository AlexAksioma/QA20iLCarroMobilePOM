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

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLocation']")
    MobileElement fieldLocation;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editFrom']")
    MobileElement fieldFrom;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editTo']")
    MobileElement fieldTo;

    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]" +
            "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    MobileElement buttonLogout;

    public SearchPage clickDots(){
        click(dots);
        return this;
    }

    public LoginPage clickLogin(){
        click(buttonLogin);
        return new LoginPage(driver);
    }

    public boolean isElementVisible_Location(){
        return isElementVisible(fieldLocation, 5);
    }

    public SearchPage logout() {
        System.out.println("-->"+buttonLogout.getText());
        click(buttonLogout);
        return this;
    }
}
