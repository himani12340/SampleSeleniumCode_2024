package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(//plugin = {"pretty","html:target/cucumber-reports"}
		//,monochrome = true
		//,
		//features ={"src/test/resources/Features/LoginApplication.feature"}
				//, features ={"src/test/resources/Features/seleniumEasyDemoSite.feature"}
				//features ={"src/test/resources/Features/End2EndTests.feature"}
		features ={"src/test/resources/Features/End2EndTests.feature"}
		//features ={"src/test/resources/Features/seleniumEasyDemoSite.feature"}
		,glue= {"stepDefinitions"}
		, tags ="@Tag1 or @Tag2"		
		
		)

public class TestRunner {

}



