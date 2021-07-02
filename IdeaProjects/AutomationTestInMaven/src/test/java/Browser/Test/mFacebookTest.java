package Browser.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class mFacebookTest extends BaseTest {

    @Test
    public void verifyUserCanLoginToFaceBook() throws InterruptedException {
        String username = ""; // Enter your valid facebook

        String password = ""; // Enter your valid facebook
        Thread.sleep(20000);
        driver.get("https://m.facebook.com/");
        driver.findElement(By.id("m_login_email")).sendKeys(username)
        ;
        driver.findElement(By.id("m_login_password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        

    }
}
