package tests;

import config.AppiumConfig;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SearchTests extends AppiumConfig {

    @Test
    public void searchPositiveTest(){
        new SplashPage(driver)
                .goToSearchPage()
                .typeFindCarForm("Haifa", "21/10/2023","22/12/2023")
                ;
    }

}
