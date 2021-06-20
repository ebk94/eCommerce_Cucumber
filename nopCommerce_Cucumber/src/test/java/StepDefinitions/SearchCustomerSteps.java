package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.CustomersPage_POM;
import pages.Login_POM;
import utils.Constants;

public class SearchCustomerSteps extends BaseClass{
	// The objects from BaseClass need to be instantiated before use
	
//	@Before
//	public void openBrowser() {
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get(Constants.URL);
//	}
	
//	@Given("User is signedIn")
//	public void user_is_signed_in() {
//		// The objects from BaseClass need to be instantiated before use
//		driver = new ChromeDriver();
//		login = new Login_POM(driver);
//		login.enterEmail("admin@yourstore.com");
//		login.enterPassword("admin");
//		login.clickLogin();
//	}
//	@When("User clicks on customers Menu")
//	public void user_clicks_on_customers_menu() {
//		customersPage = new CustomersPage_POM(driver);
//		customersPage.clickCustomerMenu();
//	}
//	@And("User click on selects Customers")
//	public void user_click_on_selects_customers() {
//		customersPage.navigateToCustomers();
//	}
//	@And("User enters customer Email")
//	public void user_enters_customer_email() {
//		customersPage.enterEmail("brenda_lindgren@nopCommerce.com");
//	}
//	@When("User clicks on search button")
//	public void user_clicks_on_search_button() {
//		customersPage.clickSearch();
//	}
//	@Then("User should find Email in the Search table")
//	public void user_should_find_email_in_the_search_table() {
//	}
	
}
