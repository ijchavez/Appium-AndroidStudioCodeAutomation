package PruebasSeleniumWebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        Map<String, Object> deviceMetrics = deviceMetrics(360, 640, 3.0);
        Map<String, Object> mobileEmulation = mobileEmulation(deviceMetrics);
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        responsiveEmulation();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("--------------------");
        String endTest = "Se ha terminado de ejecutar el test";
        System.out.println(endTest);
        //driver.close();

    }
    public HashMap<String, Object> deviceMetrics(int width, int heigth, double pixelRatio) {
        Map<String, Object> aHashMap = new HashMap<String, Object>();
        aHashMap.put("width", width);
        aHashMap.put("height", heigth);
        aHashMap.put("pixelRatio", pixelRatio);

        return (HashMap<String, Object>) aHashMap;

    }
    public HashMap<String, Object> mobileEmulation(Map<String, Object> aHashMap) {
        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", aHashMap);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) "
                + "AppleWebKit/535.19 (KHTML, like Gecko) "
                + "Chrome/18.0.1025.166 Mobile Safari/535.19");

        return (HashMap<String, Object>) mobileEmulation;

    }
    public void responsiveEmulation() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_I);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_I);

    }

}