package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.EAHomeActions;
import actions.EALoginActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.EAHomePageObject;
import pageObjects.EALoginPgaeObject;
import utility.Hooks;

public class EAHomeTest {

	public WebDriver driver;
	

	public EAHomeTest() {
		this.driver = Hooks.getDriver();
	}
	
	@Given("^I am on the EA HOME PAGE for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void browseEAHomePage(String userName, String password) {
		driver.get("http://executeautomation.com/demosite/Login.html");
		PageFactory.initElements(driver, EALoginPgaeObject.class);
		
		EALoginTest eaLogin = new EALoginTest();
		eaLogin.enterUserCredentials(userName, password);
		eaLogin.LoginClick();
		
		PageFactory.initElements(driver, EAHomePageObject.class);
		
	}
	
	@When("^I fill in user form as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void fillEAHomeUserForm(String title, String initial, String firstName, String middleName) {
		EAHomeActions.fillUserForm(title, initial, firstName, middleName);
	}
	
	@And("^I click the save button$")
	public void saveClick() {
		EAHomeActions.save();
		System.out.println("saved data");
	}
}
