package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDemoCode {
WebDriver driver ; 
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("https://demoqa.com/books");
		    driver.manage().window().maximize();
		    System.out.println("URL Launched ... ");
	}
	@When("User Navigate to LogIn Page")
	public void user_navigate_to_log_in_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.xpath("//*[@id='login']")).click();
		
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.id("log")).sendKeys(username); 	 
	    driver.findElement(By.id("pwd")).sendKeys(password);
	}
	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		System.out.println("Login Successfully");
	}



	
	
}
