package tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SplashPage;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginPositiveTest(){
        UserDto user = UserDto.builder()
                .email("alexmedqwerty@gmail.com")
                .password("Qwerty12345!")
                .build();
        new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickLogin()
                .typeEmailPassword(user)
                .clickYallaPositiveActions()
                ;


    }
}
