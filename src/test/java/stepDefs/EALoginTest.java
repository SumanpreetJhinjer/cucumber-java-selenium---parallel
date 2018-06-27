package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.EALoginActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.EALoginPgaeObject;
import utility.Hooks;

public class EALoginTest {

	public WebDriver driver;
	

	public EALoginTest() {
		this.driver = Hooks.getDriver();
	}
	
	@Given("^I browser the EA Login Page$")
	public void browseEALoginPage() {
		driver.get("http://executeautomation.com/demosite/Login.html");
		PageFactory.initElements(driver, EALoginPgaeObject.class);
		
	}
	
	@When("^I enter my (?:correct|incorrect) \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterUserCredentials(String userName, String password) {
		
		EALoginActions.enterUserInfo( userName, password);
	}
	
	@And("^I click the login button$")
	public void LoginClick() {
		EALoginActions.login();
		System.out.println("Logged In");
	}
	
	
	@Then("^I should be able to see \"([^\"]*)\"$")
	public void messageVerification(String message) {
		System.out.println("In verify");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"details\"]/h2"));
		System.out.println("element"+ element.getText());
		Assert.assertEquals(message, element.getText());
	}
}
