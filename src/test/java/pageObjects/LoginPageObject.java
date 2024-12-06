package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    public static WebDriver driver;

    //User Name
    @FindBy(xpath ="(//input[@class='app-input'])[1]")
     public WebElement username;

    //Password
    @FindBy(xpath ="(//input[@class='app-input'])[2]")
    public WebElement Password;

    //Button
    @FindBy(xpath ="//button[@type='submit']")
    public WebElement Button;

    //Memorable Word 1
    @FindBy(xpath ="//input[@formcontrolname='wordOne']")
    public WebElement One;

    //Memorable Word 2
    @FindBy(xpath ="//input[@formcontrolname='wordTwo']")
    public WebElement Two;

    //Memorable Word 3
    @FindBy(xpath ="//input[@formcontrolname='wordThree']")
    public WebElement Three;

    //Continue button
    @FindBy(xpath =" //button[text()='Continue']")
    public WebElement Continue;





    //input[@formcontrolname='wordOne']

    public LoginPageObject(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setUserName(String name)
    {
        username.sendKeys(name);
    }

    public void setUserPassword(String name)
    {
        Password.sendKeys(name);
    }


    public void clickOnSignIn()
    {
        Button.click();
    }

    public void setFirstMemorableword()
    {
        One.sendKeys("a");
    }

    public void setSecondMemorableword()
    {
        Two.sendKeys("a");
    }

    public void setThirdMemorableword()
    {
        Three.sendKeys("a");
    }

    public void clickOnContinue()
    {
        Continue.click();
    }

}
