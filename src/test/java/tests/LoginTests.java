package tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import pages.SplashPage;

public class LoginTests extends AppiumConfig {

    boolean flagIsUserLogin = false;
    boolean flagIsErrorMessageDisplays = false;
    @Test
    public void loginPositiveTest(){
        UserDto user = UserDto.builder()
                .email("alexmedqwerty@gmail.com")
                .password("Qwerty12345!")
                .build();
        flagIsUserLogin = true;
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickLogin()
                .typeEmailPassword(user)
                .clickYallaPositiveActions()
                .isElementVisible_Location())
                ;

    }

    @Test
    public void loginNegativeTest_wrongEmail(){
        UserDto user = UserDto.builder()
                .email("alexmedqwertygmail.com")
                .password("Qwerty12345!")
                .build();
        flagIsErrorMessageDisplays = true;
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickLogin()
                .typeEmailPassword(user)
                .clickYallaNegativeActions()
                .validateErrorMessage());
    }

    @AfterMethod
    public void afterMethod(){
        if(flagIsErrorMessageDisplays&&!flagIsUserLogin){
            flagIsUserLogin = true;
            flagIsErrorMessageDisplays = false;
            new LoginPage(driver)
                    .clickButtonOkErrorMessage()
                    .typeEmailPassword(UserDto.builder()
                            .email("alexmedqwerty@gmail.com")
                            .password("Qwerty12345!").build())
                    .clickYallaPositiveActions()
                    ;

        }
        if (flagIsUserLogin) {
            new SearchPage(driver).clickDots().logout();
            flagIsUserLogin = false;
            flagIsErrorMessageDisplays = true;
        }
    }
}
