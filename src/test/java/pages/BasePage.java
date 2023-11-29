package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BasePage {

    AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTextElement(MobileElement element){
        return element.getText().toUpperCase().trim();
    }

    public boolean isTextEqual(MobileElement element, String text){
        if(getTextElement(element).equals(text.toUpperCase().trim()))
            return true;
        else {
            System.out.println("text element --> " +getTextElement(element) +"not equal text -->"+text);
            return false;
        }
    }

    public void pause(int second){
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(MobileElement element){
        element.click();
    }

    public void type(MobileElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }


}
