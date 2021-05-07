package Android.Test;

import Android.Constants;
import Android.PageObject.AlertDialoguePage;
import Android.PageObject.AppOption;
import Android.PageObject.LandingPage;
import Android.PageObject.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidSampleTest extends BaseTest {

    @Test
    public void clickOnOkBtnTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        String titleTemplateText = landingPage.titleTemplateGetText();
        System.out.println(titleTemplateText);
        Assert.assertEquals(titleTemplateText, Constants.APP_NAME);

        MenuPage menuPage = landingPage.clickOnOkBtn();

    }
    @Test
    public void clickOnAlertDialoguesBtnTest(){
        LandingPage landingPage = new LandingPage(driver);
        MenuPage menuPage = landingPage.clickOnOkBtn();
        AppOption appOption = menuPage.clickOnAppBtn();
        AlertDialoguePage alertDialoguePage = appOption.clickOnAlertDialogue();

        String alertDialogueTitle = alertDialoguePage.getActionBarText();
        Assert.assertEquals(alertDialogueTitle,Constants.ALERT_DIALOGUES_MENU);
        System.out.println(">>> " + alertDialogueTitle);

    }
    @Test
    public void DialogWithALongMessageTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        MenuPage menuPage = landingPage.clickOnOkBtn();
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
        LandingPage landingPage = new LandingPage(driver);
        MenuPage menuPage = landingPage.clickOnOkBtn();
        AppOption appOption = menuPage.clickOnAppBtn();
        AlertDialoguePage alertDialoguePage = appOption.clickOnAlertDialogue();

        Thread.sleep(2000);
        alertDialoguePage.clickOntextEntryBtn();
        Thread.sleep(2000);
        alertDialoguePage.setFillUserName("usuario");
        alertDialoguePage.setFillPassword("password");
        alertDialoguePage.clickOnOkFillUserAndPasswordBtn();

    }
    
}