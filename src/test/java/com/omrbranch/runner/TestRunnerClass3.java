package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.reusablecode.JVMReportingClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@Login3",snippets = SnippetType.CAMELCASE,stepNotifications = true,dryRun = false,
plugin={"pretty", "json:target\\joutput.json"},name="verify OMR Branch login with valid credentials",
glue = "com\\omrbranch\\stepdefinition", features = "src\\test\\resources\\Features\\Login.feature")

public class TestRunnerClass3 {

	@AfterClass
	
	public static void afterClass() {
		JVMReportingClass.generateReports("C:\\Users\\ADMIN\\eclipse-workspace\\CucumberBdd\\target\\joutput.json");
	}
	
	
	
	
}
