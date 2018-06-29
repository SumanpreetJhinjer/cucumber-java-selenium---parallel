package utility;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;
public class Hooks {

	public static WebDriver driver;

	@Before
	public void setupChrome(Scenario scenario) {
		Collection<String> list =scenario.getSourceTagNames();
		System.out.println("Tag TYPE "+list);
		
			String browserType = list.toArray()[0].toString();
			System.out.println("BROWSER TYPE "+browserType);
		      if(browserType.equals("@Chrome")) {
			// initilize the browser object
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		      }else if(browserType.equals("@IE")) {
		    	  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");

		  		driver = new InternetExplorerDriver();
		      }
		      else {
		    	  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");

		          driver = new FirefoxDriver();
		      }
		

	      
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize(); // maximize the browser window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Opened browser");
	}


	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
				// This takes a screenshot from the driver at save it to the specified location
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot =ts.getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png");

		}
		driver.close();
		System.out.println("Closed browser");
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
