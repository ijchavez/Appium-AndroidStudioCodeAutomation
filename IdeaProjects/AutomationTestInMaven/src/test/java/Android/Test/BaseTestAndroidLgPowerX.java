package Android.Test;

import Android.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestAndroidLgPowerX {
    public AndroidDriver driver;
    public BaseTestAndroidLgPowerX(AndroidDriver remoteDriver){
        driver = remoteDriver;

    }
    public BaseTestAndroidLgPowerX(){

    }
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String kobitonServerUrl = "https://ijchavez:a9325c38-bad4-47b0-a0a8-797ac89a600e@api.kobiton.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
// The generated session will be visible to you only. In case you want this session available for other users, please assign this device to specific group.
        capabilities.setCapability("sessionName", "Automation test session");
        capabilities.setCapability("sessionDescription", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("captureScreenshots", true);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("deviceGroup", "KOBITON");
// For deviceName, platformVersion Kobiton supports wildcard
// character *, with 3 formats: *text, text* and *text*
// If there is no *, Kobiton will match the exact text provided
        capabilities.setCapability("app","kobiton-store:v217392");
        capabilities.setCapability("deviceName", "LG X power");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("platformName", "Android");
        PageFactory.initElements(driver, this);

    }

}
