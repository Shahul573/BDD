package com.omrbranch.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.reusablecode.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass {
	

	@Given("user is on the OMR Branch page")
	public void a() {

		//driver = new ChromeDriver();
		//driver.get("https://www.omrbranch.com/");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	

	@When("user enters {string} and {string}")
	public void b(String name, String pass) {
	    WebElement txtEmail = driver.findElement(By.id("email"));
	    txtEmail.sendKeys(name);
	    
	    WebElement txtPass = driver.findElement(By.id("pass"));
	    txtPass.sendKeys(pass);
	}



	@When("users click the login button")
	public void c() {
		WebElement btnClick = driver.findElement(By.xpath("//button[text()='Login']"));
		btnClick.click();

	}

	@Then("user should verify after login success message")
	public void user_should_verify_after_login_success_message() {
		WebElement element = driver.findElement(By.xpath("//a[@class='icoTwitter mr-2 dropdown-toggle']"));
		String text = element.getText();
		boolean contains = text.contains("Welcome");
		
		Assert.assertTrue("verify after login welcome message is displayed", contains);

	}

}
