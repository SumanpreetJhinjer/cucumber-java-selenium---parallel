package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.EAHomePageObject;

public class EAHomeActions extends EAHomePageObject {
	
	

	public EAHomeActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void fillUserForm(String title, String initial, String firstName, String middleName)
    {
        //Fill user details
       new Select(ddlTitleId).selectByVisibleText(title);
       txtInitial.sendKeys(initial);
       txtFirstName.sendKeys(firstName);
       txtMiddleName.sendKeys(middleName);
       rbMale.click();
       cbHindi.click();
        
        // return the object of the page navigated to
        //return new EAHomePOM( driver);
        
    }
    
    public static void save() {
   	//Click Login
    	btnSave.submit();
    }
}
