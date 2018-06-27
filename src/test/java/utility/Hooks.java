package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		//initilize the browser object
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize(); //maximize the browser window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Opened browser");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			System.out.println("In failed browser");
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
				
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				System.out.println("exception browser");
			} 
		}
		driver.close();
		System.out.println("Closed browser");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	

}
