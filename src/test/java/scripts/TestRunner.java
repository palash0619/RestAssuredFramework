package scripts;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = {
		"stepDefinitions" },tags= "@Addplace",plugin="json:target/jsonReports/cucumber-report.json",monochrome = true, dryRun = false, publish = true)
public class TestRunner {
	
	//Git 1st Commit from D drive

}
