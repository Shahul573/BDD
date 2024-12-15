package com.omrbranch.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE,glue = "src\\test\\java\\com\\omrbranch\\runner",features = "src\\test\\resources\\Features\\SignIn.feature")
public class SampleTestRunnerClass {

}
