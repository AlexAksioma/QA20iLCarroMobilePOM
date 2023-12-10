package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

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
    //================================================================
    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]/" +
            "android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    MobileElement buttonRegistration;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/searchBtn']")
    MobileElement buttonYalla;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage_To_date_cant_be_before_from_date;
    //=========== calendar
    @FindBy(xpath = "//*[@resource-id='android:id/prev']")
    MobileElement calendarMonthPrev;
    @FindBy(xpath = "//*[@resource-id='android:id/next']")
    MobileElement calendarMonthNext;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement calendarButtonOk;




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

    //==================================
    public RegistrationPage clickRegistration(){
        click(buttonRegistration);
        return new RegistrationPage(driver);
    }
    //==================================== calendar
    public SearchPage typeFindCarForm(String city, String dateFrom, String dateTo){
       type(fieldLocation, city);
       click(fieldFrom);
       typeCalendar(dateFrom);
       clickButtonBack();
       click(fieldTo);
       typeCalendar(dateTo);
       pause(3);
       clickButtonBack();
       return this;
    }

    //    01/03/2024       2024-2023 -1 + month  click MonthNext
    private SearchPage typeCalendar(String date) { //21/11/2023   //android.view.View[@content-desc="15 December 2023"]
        int quantityMonth=0;
        Month monthEnum = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonth();
        System.out.println("month enum -->"+monthEnum.name());
        System.out.println(monthEnum.name().charAt(0)+monthEnum.name().substring(1).toLowerCase());
        LocalDate dateNow = LocalDate.now();
        int dayNow = dateNow.getDayOfMonth();
        int monthNow = dateNow.getMonthValue();
        int yearNow = dateNow.getYear();

        String [] dateArr = date.split("/");
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);

        click(calendarMonthPrev);
        if(yearNow == year){
            quantityMonth = monthNow - month;
            if(quantityMonth>0){
                for (int i = 0; i < quantityMonth; i++) {
                    click(calendarMonthPrev);
                }
            } else if (quantityMonth<0) {
                for (int i = 0; i < Math.abs(quantityMonth); i++) {
                    click(calendarMonthNext);
                }
            }
        }else if(year > yearNow){
            quantityMonth = (year - yearNow - 1)*12 + month;
            for (int i=0; i<quantityMonth; i++){
                click(calendarMonthNext);
            }
        }else {
            quantityMonth = (yearNow - year)*12+12 - month;   // 20/11/2022       10.12.2023   (2023-2022)*12 + (12-11)
            for (int i=0; i<quantityMonth; i++){
                click(calendarMonthPrev);
            }
        }
        String monthFromDateEnum = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonth().name();
        //System.out.println(dateArr[0]+" "+monthFromDateEnum.charAt(0)+monthFromDateEnum.substring(1).toLowerCase());
        String calendarDate = String.format
                ("//android.view.View[@content-desc='%s']",
                        (dateArr[0]+" "+monthFromDateEnum.charAt(0)+monthFromDateEnum.substring(1).toLowerCase()+" "+dateArr[2]));
        System.out.println("--> "+calendarDate);
        MobileElement elementDateClick = driver.findElement(By.xpath(calendarDate));
        click(elementDateClick);
        click(calendarButtonOk);
        return this;
    }
    public SearchResultPage clickButtonYallaPositive(){
        click(buttonYalla);
        return new SearchResultPage(driver);
    }
    public SearchPage clickButtonYallaNegative(){
        click(buttonYalla);
        return this;
    }
    public boolean validateErrorMessage(){
        return textInElementPresent(errorMessage_To_date_cant_be_before_from_date,"To date can't be before from date",5);
    }
}
