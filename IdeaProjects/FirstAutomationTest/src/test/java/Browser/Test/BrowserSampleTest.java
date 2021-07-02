package Browser.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class BrowserSampleTest extends BaseTest {

    @Test
    public void sampleTest(){
        driver.get("http://automationpractice.com/index.php");
        System.out.println(driver.getCurrentUrl());

    }

}
