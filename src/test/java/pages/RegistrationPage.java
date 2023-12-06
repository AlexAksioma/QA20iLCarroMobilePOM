package pages;

import dto.UserDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends  BasePage{
    public RegistrationPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegName']")
    MobileElement fieldName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    MobileElement fieldLastName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    MobileElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    MobileElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    MobileElement checkBoxAgree;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/regBtn']")
    MobileElement buttonYalla;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessageReg;

    public RegistrationPage typeRegistrationForm(UserDto user){
        type(fieldName, user.getName());
        type(fieldLastName, user.getLastName());
        clickButtonBack();
        type(fieldEmail, user.getEmail());
        clickButtonBack();
        type(fieldPassword, user.getPassword());
        clickButtonBack();
        return this;
    }

    public RegistrationPage clickCheckBoxAgree(){
        click(checkBoxAgree);
        return this;
    }

    public SearchPage clickButtonYallaPositive(){
        click(buttonYalla);
        return new SearchPage(driver);
    }
    public boolean validateErrorMessageReg() {
        return textInElementPresent(errorMessageReg,"All fields must be filled and agree terms",5);
    }


    public RegistrationPage clickButtonYallaNegative() {
        click(buttonYalla);
        return this;
    }
}
