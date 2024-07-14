package stepDefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class End2EndTestsJavaClass {


	WebDriver driver ;
	//	https://demo.guru99.com/test/delete_customer.php
	@Given("user launches the Window Popup url")
	public void user_launches_the_window_popup_url() {
		System.setProperty("webdriver.edgedriver.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();

		driver.get("https://demo.guru99.com/popup.php");

		driver.manage().window().maximize();

	}
	@When("user clicks on Click Here link")
	public void user_clicks_on_click_here_link() {
		driver.findElement(By.xpath("//a[contains(text(),\"Click Here\")]")).click();
	}
	@Then("user navigates to child window , enter the {string} , click on submit button and captures the data")
	public void user_navigates_to_child_window_enter_the_click_on_submit_button_and_captures_the_data(String emailId) {
		String parentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();

		while(itr.hasNext())
		{
			String childWindow = itr.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("emailid")).sendKeys(emailId);
				driver.findElement(By.name("btnLogin")).click();

				String User_Id_data = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]")).getText();
				System.out.println("User_Id_data: "+User_Id_data);

				String password_and_data = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]")).getText();
				System.out.println("password_and_data: "+password_and_data);
			}
			System.out.println("\nClosing Child Windows");
			driver.close();

		}
		System.out.println("\nSwitch back to Parent Window");
		driver.switchTo().window(parentWindow);

		driver.quit();
	}


	@Given("user launches the url to test Alert functionality")
	public void user_launches_the_url_to_test_alert_functionality() {
		System.setProperty("webdriver.edgedriver.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();

		driver.get("https://demo.guru99.com/test/delete_customer.php");

		driver.manage().window().maximize();
	}
	@When("user enters the customerID {string} and click on Submit button")
	public void user_enters_the_customer_id_and_click_on_submit_button(String custID) {
		System.out.println("Enter customer id and click on submit ");
		WebElement CustID = driver.findElement(By.name("cusid"));
		CustID.sendKeys(custID);
		driver.findElement(By.name("submit")).click();

	}
	@Then("user swicthe to Alert pop-up and captures the text message")
	public void user_swicthe_to_alert_pop_up_and_captures_the_text_message() {
		System.out.println("Submitted");
		System.out.println("Switch to Alert pop-up");
		Alert alert = driver.switchTo().alert();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();


		String actualMsg = driver.switchTo().alert().getText();

		System.out.println("Success Message: "+actualMsg);
		if(actualMsg.equalsIgnoreCase("Customer Successfully Delete!"))
		{
			alert.accept();

		}
		else
		{
			System.out.println("Failure Message: "+actualMsg);
		}
		driver.quit();
	}


	@Given("user launches the url to test tooltip functionality")
	public void user_launches_the_url_to_test_tooltip_functionality() {
		System.setProperty("webdriver.edgedriver.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();

		driver.get("https://demo.guru99.com/test/social-icon.html");

		driver.manage().window().maximize();
	}
	@When("user hovers the mouse over the icon")
	public void user_hovers_the_mouse_over_the_icon() {

		
	WebElement element = driver.findElement(By.xpath("//*[@class=\"socialbtns\"]/div/a[4]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		System.out.println("Hovered over the tool tip");
		
	}
	@Then("user captures the tooltip message")
	public void user_captures_the_tooltip_message() {
		
		String ExpectedText = "Github";

		WebElement toolTip = driver.findElement(By.xpath("//*[@class=\"socialbtns\"]/div/a[4]"));
		String actualText = toolTip.getAttribute("title");

		if(actualText.equalsIgnoreCase(ExpectedText))
		{
			System.out.println("Actual Tooltip Text: "+actualText);
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Actual Tooltip Text: "+actualText);
			System.out.println("Failed");
		}
		driver.quit();
	}




}
