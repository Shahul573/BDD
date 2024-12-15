package com.omrbranch.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStep {
	
	

	@Given("user is on the amazon page")
	public void userIsOnTheAmazonPage() {
	    System.out.println("regression testing");
	}
	@When("user enter invalid user name and valid password")
	public void userEnterInvalidUserNameAndValidPassword() {
	   System.out.println("smoke twsting");
	}
	@When("user click the login button")
	public void userClickTheLoginButton() {
	  System.out.println("sanity testing");
	}
	@Then("validate the homepage")
	public void validateTheHomepage() {
	   System.out.println("regresion testing");
	}



	


}
