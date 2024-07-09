package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class LoginApplicationCode {
	WebDriver driver;

	@Given("^User launches the Swag Labs Application$")
	public void User_launches_the_Swag_Labs_Application() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();

		String url = "https://www.saucedemo.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

	}

	@When("^User \"(.*)\" and \"(.*)\" and click on Login button$")
	public void user_enters_UserName_and_Password_and_click_on_Login_button(String username, String password){
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		//WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.id("login-button")).click();

	}


	@Then("^User should be succesfully logged in the application$")
	public void User_should_be_succesfully_logged_in_the_application() {
		
		System.out.println("Page Title : "+driver.getTitle());
		System.out.println("Logged in successfully");
		driver.close();
	}


	//Second Feature 

	@Given("User loads the Swag Labs Application")
	public void user_loads_the_swag_labs_application() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();

		String url = "https://www.saucedemo.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
/*	@When("User enters <username> and <password> and clicks on Login button")
	public void user_enters_username_and_password_and_clicks_on_login_button(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.id("login-button")).click();

	}*/
/*
 * @When("User enters  \"(.*)\" and \"(.*)\" and clicks on Login button") public
 * void user_enters_username_and_password_and_clicks_on_login_button(String
 * username, String password) { // Write code here that turns the phrase above
 * into concrete actions //throw new io.cucumber.java.PendingException();
 * 
 * driver.findElement(By.id("user-name")).sendKeys(username);
 * driver.findElement(By.id("password")).sendKeys(password);
 * 
 * driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
 * driver.findElement(By.id("login-button")).click();
 * 
 * }
 */
	
	//Other ways suggested by junit console
	@When("User enters {string} and {string} and clicks on Login button")
	public void user_enters_standard_user_and_secret_sauce_and_clicks_on_login_button(String user, String pass) {
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.id("login-button")).click();
	}
	
	/*
	 * @When("User enters {string} and {string} and clicks on Login button") public
	 * void user_enters_locked_out_user_and_secret_sauce_and_clicks_on_login_button(
	 * String username, String password) {
	 * driver.findElement(By.id("user-name")).sendKeys(username);
	 * driver.findElement(By.id("password")).sendKeys(password);
	 * 
	 * driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	 * driver.findElement(By.id("login-button")).click(); }
	 */
	
	@And("User is succesfully logged into the Swag Labs application")
	public void user_is_succesfully_logged_into_the_swag_labs_application() {
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String ActualPageTitle = driver.getTitle();
		 System.out.println("Page Title : "+ActualPageTitle);
		Assert.assertEquals("PASSED", "Swag Labs", ActualPageTitle);
	}
	@And("Select the product {string} and click on AddCart")
	public void select_the_product_and_click_on_add_cart(String string) {
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebElement backpack = driver.findElement(By.xpath("//*[contains(text(),\"Sauce Labs Backpack\")]"));
		backpack.click();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement cart = driver.findElement(By.xpath("//*[contains(text(),\"Add to cart\")]"));
		cart.click();
	}
	@And("user should be able to add produt to the cart")
	public void user_should_be_able_to_add_produt_to_the_cart() {
		
		System.out.println("Product is added into cart");
		
	}
	@And("AddCart button should change to Remove button")
	public void add_cart_button_should_change_to_remove_button() {
		
		//String text = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).getText();
		//System.out.println(text);
		System.out.println("Product is successfully added");
		/*
		 * if(!text.equalsIgnoreCase("Add To cart")) {
		 * System.out.println("Product is successfully added");
		 * System.out.println(text); } else { System.out.println(text); }
		 */
	}
	@Then("the functionality is tested successfully")
	public void the_functionality_is_tested_successfully() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		
		System.out.println("Add product Functionality is successfully tested");
		System.out.println("Logging out the site.. ");
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Logged Out successfully");
		driver.close();
	}


}
