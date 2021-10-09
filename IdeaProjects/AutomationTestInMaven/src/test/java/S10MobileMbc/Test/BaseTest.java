package S10MobileMbc.Test;

import S10MobileMbc.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AndroidDriver driver;

    public BaseTest(AndroidDriver remoteDriver){
        driver = remoteDriver;

    }
    public BaseTest(){

    }
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        try{
            String appiumServerURL = Constants.APPIUM_URL;
            DesiredCapabilities dc = new DesiredCapabilities();
            setCapabilities(dc, Constants.ANDROID_DEVICE, Constants.ANDROID_11_VERSION, Constants.MBC_APP_PACKAGE, Constants.MBC_APP_ACTIVITY, Constants.S10_DEVICE_NAME );

            driver = new AndroidDriver(new URL(appiumServerURL), dc);
            PageFactory.initElements(driver, this);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Causa: " + e.getCause());
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace();

        }


    }
    public void setCapabilities(DesiredCapabilities aDesiredCapability, String aDevice, String anAndroidVersion, String anAppPackage,
                                String anAppActivity, String aDeviceName){
        aDesiredCapability.setCapability(MobileCapabilityType.PLATFORM_NAME,aDevice);
        aDesiredCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION,anAndroidVersion);
        aDesiredCapability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, anAppPackage);
        aDesiredCapability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, anAppActivity);
        aDesiredCapability.setCapability(MobileCapabilityType.NO_RESET,false);
        aDesiredCapability.setCapability(MobileCapabilityType.DEVICE_NAME, aDeviceName);
        aDesiredCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME, Constants.AUTOMATION_NAME);
        aDesiredCapability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.closeApp();

    }

}
