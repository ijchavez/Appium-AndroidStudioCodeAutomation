package Android.PageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppOption {
    AndroidDriver driver;

    public AppOption(AndroidDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath="//android.widget.TextView[@content-desc='Alert Dialogs']")
    WebElement alertDialogue;
    public AlertDialoguePage clickOnAlertDialogue(){
        alertDialogue.click();
        AlertDialoguePage alertDialoguePage = new AlertDialoguePage(driver);
        return alertDialoguePage;
    }
}
