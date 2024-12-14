package com.omrbranch.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE,stepNotifications = true,dryRun = false,plugin={"pretty","junit:target\\output.junit"},name="verify OMR Branch login with valid credentials",glue = "com\\omrbranch\\stepdefinition", features = "src\\test\\resources\\Features\\Login.feature")

public class TestRunnerClass {

}
