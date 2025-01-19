package com.omrbranch.stepdefinition;

import org.reusablecode.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	@Before

	public void beforeScenario() {
		System.out.println("...Before....");
		browserLaunch("CHROME");
		maximizeWindow();
		implicitWait(20);
		enterApplUrl("https://www.omrbranch.com/");

	}

	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("....After....");
		scenario.attach(takesScreenShot(), "image/png", scenario.getName());

		deleteCookies();
		closeWindow();

	}

}
