package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.EALoginPgaeObject;

public class EALoginActions extends EALoginPgaeObject {
	

	public EALoginActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void enterUserInfo(String userName, String password)
    {
        //Fill username
      txtUserName.sendKeys(userName);
        //Fill password
       txtPassword.sendKeys(password);
        
        // return the object of the page navigated to
        //return new EAHomePOM( driver);
        
    }
    
    public static void login() {
   	//Click Login
    	WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
    	btnLogin.submit();
    }
}
