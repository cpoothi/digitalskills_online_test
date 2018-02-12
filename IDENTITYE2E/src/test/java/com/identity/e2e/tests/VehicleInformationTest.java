package com.identity.e2e.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report_test_fileScanner",
		"json:target/basicreport_test_FileScanner.json" },
		 glue = { "com.identity.e2e.steps" }, 
		 features = {"classpath:testfeatures/" }, tags = { "@VehicleInformation" }, monochrome = true)

public class VehicleInformationTest {

}
