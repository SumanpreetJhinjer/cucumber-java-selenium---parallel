package utility;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;

public class Hooks {

	public static RemoteWebDriver driver;

	@Before
	public void setupChrome(Scenario scenario) {


		String browserType =  System.getProperty("browser");
		System.out.println("BROWSER TYPE " + browserType);
		if(browserType==null) {
			 final ChromeOptions chromeOptions = new ChromeOptions();
			    chromeOptions.setBinary("/usr/bin/google-chrome-stable");
			    chromeOptions.addArguments("--headless");
			    chromeOptions.addArguments("--disable-gpu");

			    final DesiredCapabilities dc = new DesiredCapabilities();
			    dc.setJavascriptEnabled(true);
			    dc.setCapability(
			        ChromeOptions.CAPABILITY, chromeOptions
			    );

			    driver = new ChromeDriver(dc);
		}else {
		if (browserType.equalsIgnoreCase("Chrome")) {
			// initilize the browser object
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");

			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//drivers//MicrosoftWebDriver.exe");

			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize(); // maximize the browser window
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Opened browser");

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// This takes a screenshot from the driver at save it to the specified location
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");

		}
		driver.close();
		System.out.println("Closed browser");
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
