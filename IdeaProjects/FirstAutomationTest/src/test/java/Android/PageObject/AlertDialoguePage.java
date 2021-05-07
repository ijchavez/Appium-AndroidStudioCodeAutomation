package Android.PageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertDialoguePage {
    AndroidDriver driver;

    public AlertDialoguePage(AndroidDriver remoteDriver){
        driver = remoteDriver;
        //En cada constructor debo ponerlo, mas si hago extends de clases y lo van a tomar varios
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.widget.FrameLayout[1]/" +
            "android.view.ViewGroup/android.widget.TextView")
    WebElement actionBar;
    public String getActionBarText(){
        String actionBarText = actionBar.getText();
        return actionBarText;

    }
    @FindBy(id="io.appium.android.apis:id/two_buttons2")
    WebElement dialogWithALongMessageBtn;
    public void clickOnDialogWithALongMessageBtn(){
        dialogWithALongMessageBtn.click();

    }
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    WebElement messageInDialogueWithALongMessage;
    public String getMessageText(){
        String messageText = messageInDialogueWithALongMessage.getText();
        return messageText;

    }
    @FindBy(id="android:id/button1")
    WebElement okBtnInDialogueWithALongMessage;
    public void clickOnOkBtnInDialogueWithALongMessage(){
        okBtnInDialogueWithALongMessage.click();

    }
    @FindBy(id="io.appium.android.apis:id/text_entry_button")
    WebElement textEntryBtn;
    public void clickOntextEntryBtn(){
        textEntryBtn.click();

    }
    @FindBy(id="io.appium.android.apis:id/username_edit")
    WebElement fillUserName;
    public void setFillUserName(String unUserName){
        fillUserName.sendKeys(unUserName);

    }
    @FindBy(id="io.appium.android.apis:id/password_edit")
    WebElement fillPassword;
    public void setFillPassword(String unaPassword){
        fillPassword.sendKeys(unaPassword);

    }
    @FindBy(id="android:id/button1")
    WebElement okBtnFillUserAndPasswordBtn;
    public void clickOnOkFillUserAndPasswordBtn(){
        okBtnFillUserAndPasswordBtn.click();

    }





}
