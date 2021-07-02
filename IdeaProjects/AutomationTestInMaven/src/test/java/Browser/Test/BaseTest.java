package Browser.Test;

import Android.Constants;
import io.appium.java_client.android.AndroidDriver;
import
        io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public BaseTest(AndroidDriver remoteDriver){
        driver = remoteDriver;

    }
    public BaseTest(){

    }
    public AndroidDriver driver;
    String appiumServerURL = Constants.APPIUM_URL;
    DesiredCapabilities dc = new DesiredCapabilities();
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.ANDROID_DEVICE);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.ANDROID_11_VERSION);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.ANDROID_DEVICE_NAME);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        dc.setCapability("showChromedriverLog",true);
        driver = new AndroidDriver(new URL(appiumServerURL), dc);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

}