package stepdefinitions;

//import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Role_StDef {
	WebDriver driver;
	
	@Given("^I am on Ranford page$")
	public void i_am_on_Ranford_page() throws Throwable {
		driver = new FirefoxDriver();
		//MAximise browser
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2/");
	}

	@When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_and(String Username, String Passwd) throws Throwable {
		driver.findElement(By.id("txtuId")).sendKeys(Username);
		driver.findElement(By.id("txtPword")).sendKeys(Passwd);
		Thread.sleep(3000);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		Thread.sleep(1000); 
	}

	@Then("^I naviagte to Home page$")
	public void i_naviagte_to_Home_page() throws Throwable {
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

	@When("^I click on the Role button$")
	public void i_click_on_the_Role_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();

	}

	@When("^I click on the New Role button$")
	public void i_click_on_the_New_Role_button() throws Throwable {
		//New Role
		driver.findElement(By.id("btnRoles")).click();
	}

//  Use step def by using example after the steps
	
//	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void i_enter_the_and(String RoleNm, String RoleTy) throws Throwable {
//		driver.findElement(By.id("txtRname")).sendKeys(RoleNm);
//		driver.findElement(By.id("txtRDesc")).sendKeys("Accounts Check");
//		new Select (driver.findElement(By.id("lstRtypeN"))).selectByVisibleText(RoleTy);
//		Thread.sleep(1000);
//	}
	
//Use step def for single test data in between the step without using example	

//	@When("^I enter the New Role details$")
//	public void i_enter_the_New_Role_details(DataTable Roledata) throws InterruptedException{
//		List<List<String>> Rvalue =Roledata.raw();
//		driver.findElement(By.id("txtRname")).sendKeys(Rvalue.get(0).get(0));
//		driver.findElement(By.id("txtRDesc")).sendKeys("Accounts Check");
//		Select Rtype = new Select (driver.findElement(By.id("lstRtypeN")));
//		Rtype.selectByVisibleText(Rvalue.get(0).get(1));
//		Thread.sleep(1000);
//	}
	
//Use step def for multiple test data in between the step without using example	
	
	@When("^I enter the New Role details$")
	public void i_enter_the_New_Role_details(DataTable Roledata) throws InterruptedException{
		
		for (Map<String, String> Rvalue:Roledata.asMaps(String.class, String.class))
		{
			driver.findElement(By.id("btnRoles")).click();
			driver.findElement(By.id("txtRname")).sendKeys(Rvalue.get("RoleName"));
			Select Rtype = new Select (driver.findElement(By.id("lstRtypeN")));
			Rtype.selectByVisibleText(Rvalue.get("RoleType"));
			Thread.sleep(4000);
			driver.findElement(By.id("btninsert")).click();
			driver.switchTo().alert().accept();
		}
	
	}

	@When("^I click on the Submit button$")
	public void i_click_on_the_Submit_button() throws Throwable {
		//Submit
		driver.findElement(By.id("btninsert")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}
	
	@Then("^I see the required message after role creation$")
	public void i_see_the_required_message_after_role_creation() throws Throwable {
		
		String Expval = "New Role with id Created Successfully";
		String Actval = driver.switchTo().alert().getText();
		if (Actval.contains(Expval))
		{
			System.out.println("New Role with id Created Successfully");
		}
		else
		{
			System.out.println("Role Already Existed");
		}
		driver.switchTo().alert().accept();
	}

	@Then("^I am back to Home page$")
	public void i_am_back_to_Home_page() throws Throwable {
	
	driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
	Thread.sleep(1000);
	}
	
	
	@Then("^I logout of the application$")
	public void i_logout_of_the_application() throws Throwable {
	
		driver.close();
		
	}

	
}
