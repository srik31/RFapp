package runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Srikalyani Kotha\\eclipse-sriworkspace\\CucumberJava\\src\\features\\Role.feature", 
				 glue = "stepdefinitions", monochrome = true,
				 plugin = {"pretty", "json: target/reports/login.json"})

public class Admlog {
	
					}
