package TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

@Listeners (TestListener.TestListeners.class)
public class SpotifyTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");

        context.setAttribute("WebDriver", driver);
    }
   //@Test (successPercentage = 60, invocationCount = 5)
    @Test
    public void testSpotify(){
        System.out.println("Title " + driver.getTitle());
        SoftAssert sA = new SoftAssert();

        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        List<WebElement> errorList = driver.findElements(By.tagName("span"));
        Assert.assertNotEquals(errorList.size(), 0);
        for (WebElement e: errorList){
            if (e.getText().equals("Es necesario que introduzcas tu correo electrónico.")){
                sA.assertTrue(false);
            }
            //Assert.assertNotEquals(e.getText(), "Es necesario que introduzcas tu correo electrónico.");

        }
    }

    private int i = 0;
    @Test (successPercentage = 40, invocationCount = 5)
    //el successPercentage es 0, es decir, aunque fallen todos los test, el resultado sera exitoso
    //el successPercentage = 60 representa a que debe pasar el 60% de las ejecuciones, tiene que pasar los 3 de 5 ejecuciones
    //el successPercentage = 80 representa a que debe pasar el 80% de las ejecuciones, tiene que pasar los 4 de 5 ejecuciones
    //el successPercentage = 100 representa a que no se toleran fallas, tiene que pasar los 5 tests
    public void porcentageTestSuccessRate(){
        i++;
        System.out.println("i vale " + i);
        if ( i == 1 || i == 2) {
            Assert.assertTrue(false);
        }
    }
}
