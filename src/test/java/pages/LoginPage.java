package pages;

import dto.UserDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    MobileElement buttonYalla;

    public LoginPage typeEmailPassword(UserDto user){
        type(fieldEmail, user.getEmail());
        type(fieldPassword, user.getPassword());
        return this;
    }

    public SearchPage clickYallaPositive(){
        click(buttonYalla);
        return new SearchPage(driver);
    }
    public SearchPage clickYallaPositiveActions(){
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonYalla,0,-10).click().perform();
        return new SearchPage(driver);
    }
}
