package WindowsDriver;

import Android.Constants;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public WindowsDriver<WindowsElement> driver;
    String appiumServerURL = Constants.APPIUM_URL;
    DesiredCapabilities dc = new DesiredCapabilities();

    public BaseTest(WindowsDriver<WindowsElement> remoteDriver){
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
            DesiredCapabilities appCapabilities = new DesiredCapabilities();
            appCapabilities.setCapability("platformName", "windows");
            appCapabilities.setCapability("deviceName", "WindowsPC");
            appCapabilities.setCapability("app", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

            driver = new WindowsDriver<WindowsElement>(new URL(appiumServerURL), dc);

        }catch (Exception e){
            System.out.println("Causa: " + e.getCause());
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace();

        }

    }
    @Test public void test(){

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.close();

    }

}
