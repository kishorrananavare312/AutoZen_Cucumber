package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Feature",
	    glue = {"com.stepDefination"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-report.html",
	        "json:target/cucumber.json"
	    },
	    monochrome = true
	)
	public class FetaureRunner extends AbstractTestNGCucumberTests {
	}
