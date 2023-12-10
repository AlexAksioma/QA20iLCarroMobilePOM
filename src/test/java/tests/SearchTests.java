package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SearchTests extends AppiumConfig {

    @Test
    public void searchPositiveTest(){
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .typeFindCarForm("Haifa", "05/05/2024","01/11/2024")
                .clickButtonYallaPositive()
                .isTextInElementPresent_Search_result())
                ;
    }
    @Test
    public void searchNegativeTest_dateFromAfterDateTo(){
        Assert.assertTrue(new SplashPage(driver)
                .goToSearchPage()
                .typeFindCarForm("Haifa", "05/05/2024","01/03/2024")
                .clickButtonYallaNegative()
                .validateErrorMessage())
                ;
    }

}
