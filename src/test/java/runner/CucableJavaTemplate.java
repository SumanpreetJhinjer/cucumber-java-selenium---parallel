package runner;

import java.io.File;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = {"target/parallel/features/[CUCABLE:FEATURE].feature"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-report/[[CUCABLE:RUNNER].report.html"}
)
public class CucableJavaTemplate {
    // [CUCABLE:CUSTOM:comment]
	 public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Machine", 	System.getProperty("os.name"));
		    Reporter.setSystemInfo("Selenium", "3.11.0");
		    Reporter.setSystemInfo("Maven", "4.0.0");
		    Reporter.setSystemInfo("Java Version", "10.0.1");
	    
	    }
}