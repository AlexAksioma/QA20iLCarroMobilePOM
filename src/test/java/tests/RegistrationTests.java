package tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        UserDto user = UserDto.builder()
                .name("Frodo")
                .lastName("Baggins")
                .email("bagginsfrodo"+i+"@gmail.com")
                .password("Qwerty12345!")
                .build();
        //flagIsUserLogin = true;
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxAgree()
                .clickButtonYallaPositive()
                .isElementVisible_Location()
                )
                ;
    }

    @Test
    public void registrationNegativeTest(){
        int i = new Random().nextInt(1000);
        UserDto user = UserDto.builder()
                .name("")
                .lastName("Baggins")
                .email("bagginsfrodo"+i+"@gmail.com")
                .password("Qwerty12345!")
                .build();
        //flagIsUserLogin = true;
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .clickDots()
                .clickRegistration()
                .typeRegistrationForm(user)
                .clickCheckBoxAgree()
                .clickButtonYallaNegative()
                .validateErrorMessageReg()
                )
                ;
    }
}
