package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    public SearchResultPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/resultTitle']")
    MobileElement resultTitle;

    public boolean isTextInElementPresent_Search_result(){
        return textInElementPresent(resultTitle, "Search result", 5);
    }
}
