package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Customers.feature", 
		glue={"StepDefinitions"},monochrome=true,
		plugin = {"pretty","junit:target/JUnitReports/customers_report.xml",
		"json:target/JSONReports/customers_report.json",
		"html:target/HTMLReports/customers_login.html"},
		dryRun = false,
		tags = "@sanity" 
		)

// To run multiple feature files
// features={"./features/Customers.feature", "./features/login.feature"}

// To run all of them
//features="./features/",

public class TestRunnerForCustomers {

}
