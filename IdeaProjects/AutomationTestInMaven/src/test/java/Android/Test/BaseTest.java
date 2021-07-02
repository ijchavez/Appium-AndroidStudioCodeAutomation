package Android.Test;

import Android.Constants;
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
        /****
         *  vi el try/catch en un video que lo hace una persona para manejar los errores en este punto:
         *  https://www.youtube.com/watch?v=UlktcBntD6s&list=PL55Ae8AHavdjRweFoBHLlTMwhUpN8AmCG&index=1&t=4s
         */


        try{
            String appiumServerURL = Constants.APPIUM_URL;
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME,Constants.ANDROID_DEVICE);
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,Constants.ANDROID_11_VERSION);
            /****
             * Comento esta linea:
             * dc.setCapability(MobileCapabilityType.APP,Constants.APK_PATH);
             * y uso appPackage y appActivity, tomados desde el logcag de ADB para que la app no
             * me pida aceptar permisos y entre directamente.
             * Como resultado de esto el primer OK que antes traía la aplicacion ahora no lo hace
             */
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,Constants.APP_PACKAGE);
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,Constants.APP_ACTIVITY);
            dc.setCapability("noReset",true);
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.ANDROID_DEVICE_NAME);
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                    Constants.AUTOMATION_NAME);
            driver = new AndroidDriver(new URL(appiumServerURL), dc);
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
        Thread.sleep(2000);
        driver.closeApp();

    }
}
