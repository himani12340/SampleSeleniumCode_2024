/*package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	WebDriver driver;

	@Before
	public void beforeScenario()
	{
		System.out.println("-------------Start Test --------------");
	}
	
	 @AfterStep
	    public void beforeEachStep(io.cucumber.java.Scenario sc) throws IOException{
		 //screenshots();
		 
		 if(sc.isFailed())
			{
				TakesScreenshot src =  ((TakesScreenshot)driver);
				byte[] screenshot = src.getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", "Screenshot taken for Passed scenarios");
				

			}
			else
			{
				TakesScreenshot src =  ((TakesScreenshot)driver);
				byte[] screenshot = src.getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", "Screenshot taken for Passed scenarios");
			
			}
	    }
	@After
	public void after_scenario()
	{
		
		driver.quit();
		
		System.out.println("-------------Test Completed--------------");
	}
}

*/