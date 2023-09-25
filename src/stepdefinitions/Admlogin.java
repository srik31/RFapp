package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Admlogin {
	WebDriver driver;
	
	@Given("^I want to be on the Ranford page$")
	public void i_want_to_be_on_the_Ranford_page() throws Throwable {
		
		driver = new FirefoxDriver();
		//MAximise browser
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2/");
		
		
	}

	@When("^I enter the Username and Passwd$")
	public void i_enter_the_Username_and_Passwd() throws Throwable {
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("TestingMindq");
		Thread.sleep(3000);
		
	}
	

	@When("^I click the login button$")
	public void i_click_the_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		Thread.sleep(1000); 
	}
		
	@Then("^I navigate to the Homepage$")
	public void i_navigate_to_the_Homepage() throws Throwable {
		
//		Get Title
		String ExpTitle = "MINDQ RANFORD BANK";
		String ExpUrl = "http://103.211.39.246/ranford2/";
		String ActTitle = driver.getTitle();
		System.out.println(ActTitle);
		String ActUrl = driver.getCurrentUrl();
		System.out.println(ActUrl);
		
		if (ExpTitle.equalsIgnoreCase(ActTitle))
		{
			System.out.println("Application launched is right one");
		}
		else
		{
			System.out.println("Not the correct Application");
		}
		if (ExpUrl.equalsIgnoreCase(ActUrl))
		{
			System.out.println("Application launched has the right Url");
		}
		else
		{
			System.out.println("Not the correct Url");
		}

		
	}
		   
}
