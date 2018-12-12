package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class EALoginPgaeObject extends BaseClass{
	
	 public EALoginPgaeObject(WebDriver driver)
     {
         super(driver);
     }

     //use of FindsBy in POM
     @FindBy(how =How.NAME, using = "UserName")
     public static WebElement txtUserName;

     @FindBy(how =How.NAME, using = "Password")
     public static WebElement txtPassword;

     @FindBy(how =How.NAME, using = "Login")
     public static WebElement btnLogin;

     
 }


