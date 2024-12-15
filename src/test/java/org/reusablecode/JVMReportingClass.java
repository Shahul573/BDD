package org.reusablecode;

import java.io.File;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

public class JVMReportingClass {
	public static void generateReports(String jsonPath) {

		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\CucumberBdd\\target");

		net.masterthought.cucumber.Configuration configuration = new net.masterthought.cucumber.Configuration(file,
				"15-12-2024");

		configuration.addClassifications("OS", "Win-10");

		configuration.addClassifications("Browser", "Chrome");

		configuration.addClassifications("SprintNo", "13");

		configuration.addClassifications("Env", "UAT");

		List<String> li = new ArrayList<String>();
		li.add(jsonPath);

		ReportBuilder builder = new ReportBuilder(li, configuration);

		builder.generateReports();

	}

}
