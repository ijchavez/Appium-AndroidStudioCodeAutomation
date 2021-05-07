package Android.Test;

import Android.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;

    public BaseTest(AndroidDriver remoteDriver){
        driver = remoteDriver;

    }
    public BaseTest(){

    }
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String appiumServerURL = Constants.APPIUM_URL;
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,Constants.ANDROID_DEVICE);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.ANDROID_11_VERSION);
        dc.setCapability(MobileCapabilityType.APP,Constants.APK_PATH);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.ANDROID_DEVICE_NAME);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,Constants.AUTOMATION_NAME);
        dc.setCapability("autoGrantPermissions", "true");
        driver = new AndroidDriver(new URL(appiumServerURL), dc);
        PageFactory.initElements(driver, this);

    }

}
