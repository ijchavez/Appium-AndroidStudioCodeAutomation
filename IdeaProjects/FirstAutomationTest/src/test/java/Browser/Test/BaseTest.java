package Browser.Test;

import Android.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;


/***
 * Si pasa este error:
 * Cannot invoke “io.appium.java_client.android.AndroidDriver.manage()” because “this.driver” is null
 * revisar que este levantado Appium
 */
public class BaseTest {
    public AppiumDriver<MobileElement> driver;
    String appiumServerURL = Constants.APPIUM_URL;
    DesiredCapabilities dc = new DesiredCapabilities();

    public BaseTest(AppiumDriver<MobileElement> remoteDriver){
        driver = remoteDriver;

    }
    public BaseTest(){

    }
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        /****
         *  vi el try/catch en un video que lo hace una persona para manejar los errores en este punto:
         *  https://www.youtube.com/watch?v=UlktcBntD6s&list=PL55Ae8AHavdjRweFoBHLlTMwhUpN8AmCG&index=1&t=4s
         */
        try{
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME,Constants.ANDROID_DEVICE);
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.ANDROID_11_VERSION);
            dc.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.ANDROID_DEVICE_NAME);
            driver = new AppiumDriver<MobileElement>(new URL(appiumServerURL), dc);

            PageFactory.initElements(driver, this);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }catch (Exception e){
            System.out.println("Causa: " + e.getCause());
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace();

        }


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.close();

    }
}
