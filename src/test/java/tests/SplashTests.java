package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;

public class SplashTests extends AppiumConfig {

    @Test
    public void splashTestValidateVersion(){
        Assert.assertTrue(new SplashPage(driver).validateVersionApp());
    }
}
