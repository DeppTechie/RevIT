package com.nsw.cucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(	
			plugin = {"pretty", "html:target/test/", "json:json_output/cucumber.json"},
			features = "src/test/java/features/nswNumberPlate.feature",
			glue="com/nsw/stepDefinations",
			monochrome = true,
			tags = {"@FunctionalTest"}		
						
)	
public class TestRunner {
}