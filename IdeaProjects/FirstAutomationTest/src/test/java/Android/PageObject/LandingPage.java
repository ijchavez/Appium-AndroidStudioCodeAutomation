package Android.PageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    AndroidDriver driver;

    public LandingPage(AndroidDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(id="android:id/button1")
    WebElement okBtn;
    public MenuPage clickOnOkBtn(){
        okBtn.click();
        MenuPage menuPage = new MenuPage(driver);
        return menuPage;

    }
    @FindBy(id="android:id/alertTitle")
    WebElement titleTemplate;
    public String titleTemplateGetText(){
        String titleTemplateText = titleTemplate.getText();
        return titleTemplateText;

    }

}
