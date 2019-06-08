package bddcucumber.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("As a user when I launch application in chrome$")
	public void as_a_user_launch_application() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		System.setProperty("webdriver.chrome.driver", "E:\\_AkashStuff\\Automation\\dependencies\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com/login.html");
	}

	@When("I enter user name")
	public void enter_user_name() {
		WebElement txtbx_username = driver.findElement(By.name("user_login"));
		txtbx_username.sendKeys("username");
	}

	@When("I enter password")
	public void enter_password() {
		driver.findElement(By.name("user_password")).sendKeys("password");
	}

	@When("I click submit button")
	public void click_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("I should be logged in to the application")
	public void should_be_logged_in_to_the_application() {
		String expected_title = "Zero - Account Summary";
		String actual_title = driver.getTitle();
		Assert.assertEquals(expected_title, actual_title);
	}
}
