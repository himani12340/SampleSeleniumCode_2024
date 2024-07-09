package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		driver = new EdgeDriver();

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
	public void user_clicks_on_datepicker() throws IOException {


		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,200);");
		//Method 1 - using sendKeys

		WebElement date1 = driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/input"));
		date1.sendKeys("08/08/1991");
		//date1.sendKeys(Keys.ENTER);
		
	/*	TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("D:\\Selenium Tutorial\\Workspace\\output.png");
		
		FileUtils.copyFile((File) srcShot, DestFile);*/
		
		
	//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//System.out.println("Date Entered - "+date1.getText());

	/*	//Clear the date using "Clear" and from the date picker select "Today"
		date1.click();
		WebElement clear = driver.findElement(By.xpath("//div[3]/div[1]/table/tfoot/tr[2]/th"));
				clear.click();
		//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		WebElement Today = driver.findElement(By.xpath("//div[3]/div[1]/table/tfoot/tr[1]/th"));
		Today.click();
*/
	
	
	}
	@When("Selects the date from the calender")
	public void selects_the_date_from_the_calender() throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,600);");
		System.out.println("Enter Start date and End Date");

		WebElement startDate = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]"));
		startDate.sendKeys("01/07/2024");
		startDate.sendKeys(Keys.ENTER);
		startDate.sendKeys(Keys.TAB);


		WebElement endDate = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]"));
		endDate.sendKeys("12/12/2025");
		endDate.sendKeys(Keys.ENTER);
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		File DestFile = new File("D:\\Selenium Tutorial\\Workspace\\output2.png");
		
		FileUtils.copyFile((File) srcShot, DestFile);

	}
	@Then("Date should appear in the text box successfully")
	public void date_should_appear_in_the_text_box_successfully() {
		System.out.println("Date Selection functionality done successfully");
		driver.quit();
	}
	
	

}
