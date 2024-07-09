package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class End2EndTestsJavaClass {


	WebDriver driver ;
	
	@Given("user launches the url")
	public void user_launches_the_url() {
	    
	}
	@When("user clicks on Open New window Button")
	public void user_clicks_on_open_new_window_button() {
	   
	}
	@Then("user navigates to child window and click on Form option")
	public void user_navigates_to_child_window_and_click_on_form_option() {
	   
	}
	@Then("Fills the Form and click on Submit and captures the Form Successfull message")
	public void fills_the_form_and_click_on_submit_and_captures_the_form_successfull_message() {
	   
	}
	@Then("Close the child window and switch back to parent window")
	public void close_the_child_window_and_switch_back_to_parent_window() {
	   
	}
	
	
	@When("user clicks on Open New Alert Button")
	public void user_clicks_on_open_new_alert_button() {
	    
	}
	@Then("user swicthes to Alert pop-up and captures the text message")
	public void user_swicthes_to_alert_pop_up_and_captures_the_text_message() {
	    
	}
	@Then("user accepts the alert")
	public void user_accepts_the_alert() {
	    
	}

}
