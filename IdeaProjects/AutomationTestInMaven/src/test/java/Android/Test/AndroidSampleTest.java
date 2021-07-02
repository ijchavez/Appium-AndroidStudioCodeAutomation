package Android.Test;

import Android.Constants;
import Android.PageObject.AlertDialoguePage;
import Android.PageObject.AppOption;
import Android.PageObject.LandingPage;
import Android.PageObject.MenuPage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidSampleTest extends BaseTest {

    /****
     *  Con la nueva configuracion del desireCapabilities queda en desuso
     *  @Test
     *  public void clickOnOkBtnTest(){
     *      LandingPage landingPage = new LandingPage(driver);
     *      String titleTemplateText = landingPage.titleTemplateGetText();
     *      System.out.println(">>> " + titleTemplateText);
     *      Assert.assertEquals(titleTemplateText, Constants.APP_NAME);
     *      MenuPage menuPage = landingPage.clickOnOkBtn();
     *  }
     */
    @Test
    public void clickOnAlertDialoguesBtnTest(){
        /*****
         * Con la nueva configuracion del desireCapabilities queda en desuso
         * LandingPage landingPage = new LandingPage(driver);
         */
        MenuPage menuPage = new MenuPage(driver);
        AppOption appOption = menuPage.clickOnAppBtn();
        AlertDialoguePage alertDialoguePage = appOption.clickOnAlertDialogue();

        String alertDialogueTitle = alertDialoguePage.getActionBarText();
        Assert.assertEquals(alertDialogueTitle,Constants.ALERT_DIALOGUES_MENU);
        System.out.println(">>> " + alertDialogueTitle);

    }
    @Test
    public void DialogWithALongMessageTest() throws InterruptedException {
        /*****
         * Con la nueva configuracion del desireCapabilities queda en desuso
         * LandingPage landingPage = new LandingPage(driver);
         */
        MenuPage menuPage = new MenuPage(driver);
        AppOption appOption = menuPage.clickOnAppBtn();
        AlertDialoguePage alertDialoguePage = appOption.clickOnAlertDialogue();

        alertDialoguePage.clickOnDialogWithALongMessageBtn();
        Thread.sleep(2000);
        String messageText = alertDialoguePage.getMessageText();
        System.out.println(">>> " + messageText);
        Assert.assertTrue(messageText.contains("Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno"));

        Thread.sleep(2000);
        alertDialoguePage.clickOnOkBtnInDialogueWithALongMessage();

        String alertDialogueTitle = alertDialoguePage.getActionBarText();
        Assert.assertEquals(alertDialogueTitle,Constants.ALERT_DIALOGUES_MENU);
        System.out.println(">>> " + alertDialogueTitle);

    }
    @Test
    public void setUserAndPasswordTest() throws InterruptedException {
        /*****
         * Con la nueva configuracion del desireCapabilities queda en desuso
         * LandingPage landingPage = new LandingPage(driver);
         */
        MenuPage menuPage = new MenuPage(driver);
        AppOption appOption = menuPage.clickOnAppBtn();
        AlertDialoguePage alertDialoguePage = appOption.clickOnAlertDialogue();

        Thread.sleep(2000);
        alertDialoguePage.clickOntextEntryBtn();
        Thread.sleep(2000);
        alertDialoguePage.setFillUserName("usuario");
        alertDialoguePage.setFillPassword("password");
        alertDialoguePage.clickOnOkFillUserAndPasswordBtn();

    }

    /***
     * Este test lo genere directamente grabando desde appium cada uno de los movimientos.
     * La aplicacion va generando el codigo y una vez terminado simplemente es copiarlo
     * y pegarlo en un test
     */
    @Test
    public void grabacionDesdeAppiumTest(){
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("App");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Alert Dialogs");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Text Entry dialog");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("io.appium.android.apis:id/username_edit");
        el4.sendKeys("usuario");
        MobileElement el5 = (MobileElement) driver.findElementById("io.appium.android.apis:id/password_edit");
        el5.sendKeys("password");
        MobileElement el6 = (MobileElement) driver.findElementById("android:id/button1");
        el6.click();
    }
    @Test
    public void testdeprueba(){
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("App");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Alert Dialogs");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Text Entry dialog");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("io.appium.android.apis:id/username_edit");
        el4.sendKeys("unValor");
        MobileElement el6 = (MobileElement) driver.findElementById("io.appium.android.apis:id/password_edit");
        el6.sendKeys("password");
        MobileElement el7 = (MobileElement) driver.findElementById("android:id/button1");
        el7.click();

    }
    
}