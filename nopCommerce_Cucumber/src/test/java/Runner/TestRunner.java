package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/", 
		glue={"StepDefinitions"},monochrome=true,
		plugin = {"pretty","junit:target/JUnitReports/reportAll.xml",
		"json:target/JSONReports/reportAll.json",
		"html:target/HTMLReports/reportAll.html"},
		dryRun = false
		)

public class TestRunner {

}
