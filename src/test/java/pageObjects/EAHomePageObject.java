package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class EAHomePageObject extends BaseClass{
	
	 public EAHomePageObject(WebDriver driver)
     {
         super(driver);
     }

     //use of FindsBy in POM
     @FindBy(how =How.ID, using = "TitleId")
     public static WebElement ddlTitleId;

     @FindBy(how =How.NAME, using = "Initial")
     public static WebElement txtInitial;
     
     @FindBy(how =How.NAME, using = "FirstName")
     public static WebElement txtFirstName;
     
     @FindBy(how =How.NAME, using = "MiddleName")
     public static WebElement txtMiddleName;

     @FindBy(how =How.NAME, using = "Male")
     public static WebElement rbMale;
     
     @FindBy(how =How.NAME, using = "Hindi")
     public static WebElement cbHindi;
     
     @FindBy(how =How.NAME, using = "Save")
     public static WebElement btnSave;

     
 }


