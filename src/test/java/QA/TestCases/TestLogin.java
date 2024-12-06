package QA.TestCases;

import baseClass.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;

public class TestLogin extends BaseTest {

    @Test
    public void VerifyLoginFunctionality() throws InterruptedException {
        LoginPageObject lg1=new LoginPageObject(BaseTest.driver);
        extentTest.info("setUserName"); lg1.setUserName("regression.user1");
        extentTest.info("setUserPassword"); lg1.setUserPassword("KashFlow1");
        extentTest.info("clickOnSignIn"); lg1.clickOnSignIn();

         //set Memorable word
       // extentTest.info("setFirstMemorableword"); lg1.setFirstMemorableword();
        //extentTest.info("setSecondMemorableword"); lg1.setSecondMemorableword();
        //extentTest.info("setThirdMemorableword"); lg1.setThirdMemorableword();
        //extentTest.info("clickOnContinue");  lg1.clickOnContinue();
        Thread.sleep(5000);
    }


}
