package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class seleniumEasyDemoSiteCode {

	WebDriver driver;
		
	@Given("user launches the site")
	public void user_launches_the_site() {
		System.setProperty("webdriver.edge.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		//driver = new EdgeDriver();
		
		System.out.println("Launching Web Browser .....");
		
		driver.get("https://demo.seleniumeasy.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		System.out.println("Click on Start Practicing --- ");
		
		driver.findElement(By.xpath("//*[contains(text(),\" Start Practising \")]")).click();
		

	}
	@When("user clicks on Input Forms Link")
	public void user_clicks_on_input_forms_link() {
		System.out.println("-----Open Input Forms-----");
		//driver.findElement(By.xpath("//*[text()='Input Forms']/@href")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),\"Input Forms\")]")).click();
		
		//driver.findElement(By.linkText("Input Forms")).click();
		System.out.println("-----Input Forms Page successfully clicked-----");

	}

	
	@And("user navigates to Select Drop Down List option")
	public void user_navigates_to_select_drop_down_list_option() {
		driver.findElement(By.xpath("//a[@href = './basic-select-dropdown-demo.html']")).click();
		System.out.println("-----Select Drop Down List successfully clicked-----");
	    
	}
	/*
	 * @And("user selects Sunday from the select a day list and California from multi Select List"
	 * ) public void
	 * user_selects_sunday_from_the_select_a_day_list_and_California_from_multi_Select_List
	 * () {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("window.scrollBy(0,500);"); WebElement day =
	 * driver.findElement(By.xpath("//*[@id='select-demo']"));//*[@id=
	 * 'select-demo'] Select selectDay = new Select(day);
	 * selectDay.selectByIndex(0); selectDay.selectByVisibleText("Sunday");
	 * 
	 * 
	 * WebElement city = driver.findElement(By.xpath("//*[@id='multi-select']"));
	 * Select selectCity = new Select(city);
	 * selectCity.selectByVisibleText("California");
	 * 
	 * }
	 */
	
	@And("user selects Sunday from the select a day list")
	public void user_selects_sunday_from_the_select_a_day_list() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,250);");
		
		WebElement day = driver.findElement(By.id("select-demo"));
		Select selectDay = new Select(day);
		selectDay.selectByVisibleText("Sunday");
		
		WebElement printFirstSelected = driver.findElement(By.xpath("//p[@class='selected-value']"));
		printFirstSelected.click();
		
		System.out.println(printFirstSelected.getText());
		
		for(int i=0; i<selectDay.getOptions().size();i++)
		{
			System.out.println("List : "+selectDay.getOptions().get(i).getText());
		}
	}
	
	@Then("user selects California from multi Select List")
	public void user_selects_California_from_multi_Select_List() {
		
		
				
		WebElement city = driver.findElement(By.xpath("//*[@name='States']"));
		Select selectCity = new Select(city);
		
		for(int i=0; i<selectCity.getOptions().size();i++)
		{
			System.out.println("List : "+selectCity.getOptions().get(i).getText());
		}
		
		selectCity.selectByVisibleText("California");
		
		WebElement printFirstSelected = driver.findElement(By.id("printMe"));
		printFirstSelected.click();
		
		String Text2 = driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
		System.out.println(Text2);
		
		WebElement AllSelected = driver.findElement(By.id("printAll"));
		AllSelected.click();
		
		String Text3 = driver.findElement(By.xpath("//p[@class='getall-selected']")).getText();
		System.out.println(Text3);
		
		
		System.out.println("Closing Web Browser .....");
		driver.quit();
	   
	}
	
	
	@Given("user is on HomePage and navigates to Date Picker option")
	public void user_is_on_home_page_and_navigates_to_date_picker_option() {
		
		System.setProperty("webdriver.edge.driver", "D:\\Selenium Tutorial\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		System.out.println("Launching Web Browser .....");
		
		driver.get("https://demo.seleniumeasy.com/");
		driver.manage().window().maximize();
		System.out.println("Page Title : "+driver.getTitle());
	    		
		driver.findElement(By.xpath("//*[contains(text(),\"Date pickers\")]")).click();
		System.out.println("Page Title : "+driver.getTitle());
		driver.findElement(By.xpath("//*[contains(text(),\"Bootstrap Date Picker\")]")).click();
		
		System.out.println("Page launched to perform Date Selection Functionality");
		System.out.println("Page Title : "+driver.getTitle());
	    
	}
	@When("user clicks on datepicker")
	public void user_clicks_on_datepicker() {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,200);");
		//Method 1 - using sendKeys
		
		WebElement date1 = driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/input"));
		date1.sendKeys("08/08/1991");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		System.out.println("Date Entered - "+date1.getText());
		
		//Clear the date again and from the date picker select "Today"
		
		date1.clear();
		date1.findElement(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")).click();
		System.out.println("New Date Entered - "+date1.getText());
		
		//Method 2
		//	
		
		
		// Year = /html/body/div[3]
		//month = /html/body/div[3]
		//July - > /html/body/div[3]/div[1]/table/thead/tr[2]/th[2]
		//month List -> Jan -> /html/body/div[3]/div[2]/table/tbody/tr/td/span[1]
		//Feb - /html/body/div[3]/div[2]/table/tbody/tr/td/span[2]
	}
	@When("Selects the date from the calender")
	public void selects_the_date_from_the_calender() {
		System.out.println("Enter Start date and End Date");
			
		WebElement startDate = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]"));
		startDate.sendKeys("");
		startDate.sendKeys(Keys.TAB);
		
		
		WebElement endDate = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]"));
		endDate.sendKeys("12/12/2025");
		endDate.sendKeys(Keys.TAB);
		
	}
	@Then("Date should appear in the text box successfully")
	public void date_should_appear_in_the_text_box_successfully() {
		System.out.println("Date Selected");
	}

}
