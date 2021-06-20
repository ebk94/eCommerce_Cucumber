package StepDefinitions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddCustomerPage_POM;
import pages.CustomersPage_POM;
import pages.Login_POM;
import utils.Constants;

public class CustomerFunctionalitySteps extends BaseClass {

	@Before
	public void browserSetup() throws IOException {
		// Log4j logger
		logger=Logger.getLogger("nopCommerce_Cucumber");//Added logger
		PropertyConfigurator.configure("log4j.properties"); // Added logger
	
		//Reading properties file
		configProp = new Properties(); // creating new instance of the Properties object
		// Input stream to read the config.properties
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile); // Loading the config.properties file
		// System Property
		String br = configProp.getProperty("browser"); // br - browser
		logger.info("****** Launching the Browser ******");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("msedge")) {
			System.setProperty("webdriver.edge.driver", configProp.getProperty("msedgepath"));
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		logger.info("****** Opening URL ******");
		driver.get(Constants.URL);
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Given("user signed with valid credentials")
	public void user_signed_with_valid_credentials() throws InterruptedException {
		logger.info("****** Providing credentials ******");
		login = new Login_POM(driver);
		login.enterEmail(Constants.EMAIL);
		login.enterPassword(Constants.Password);
		login.clickLogin();
		Thread.sleep(2000);
	}
	@Given("user can view Dashboard")
	public void user_can_view_dashboard() {
		logger.info("****** Login passed ******");
	}
	@When("user clicks on customers Menu")
	public void user_clicks_on_customers_menu() {
		customersPage = new CustomersPage_POM(driver);
		customersPage.clickCustomerMenu();
	}
	@When("clicks on customers Menu")
	public void clicks_on_customers_menu() {
		customersPage.navigateToCustomers();
	}
	@When("clicks on Add new button")
	public void clicks_on_add_new_button() {
		logger.info("****** Adding new Customer ******");
		customersPage.addNewUser();
	}
	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	}
	@When("user enters customer Info and saves")
	public void user_enters_customer_info_and_saves() throws InterruptedException {
		addCustomer = new AddCustomerPage_POM(driver);
		addCustomer.setEmailAndPswd(generateRandomAlphabet()+"@gmail.com", "admin");
		addCustomer.enterFullName("Ben", "Askren");
		addCustomer.setGenderAndDate("05/05/1995");
		addCustomer.setSubscription();
		addCustomer.setRole();
		addCustomer.selectVendor();
		addCustomer.addComment("This is for testing ... ");
		addCustomer.clickSave();
		logger.info("****** Saved successfully ******");
	}
	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body"))
				.getText().contains("The new customer has been added successfully"));
		logger.info("****** Test passed ******");
	}
	
	// Testing search functionality
	
	@Given("User is signedIn")
	public void user_is_signed_in() {
		// The objects from BaseClass need to be instantiated before use
		login = new Login_POM(driver);
		login.enterEmail("admin@yourstore.com");
		login.enterPassword("admin");
		login.clickLogin();
	}
	
	@When("User clicks on customers Menu")
	public void User_clicks_on_customers_menu() {
		customersPage = new CustomersPage_POM(driver);
		customersPage.clickCustomerMenu();
	}
	
	@And("User click on selects Customers")
	public void user_click_on_selects_customers() {
		customersPage.navigateToCustomers();
	}
	@And("User enters customer Email")
	public void user_enters_customer_email() {
		customersPage.enterEmail("brenda_lindgren@nopCommerce.com");
	}
	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		customersPage.clickSearch();
	}
	@Then("User should find Email in the Search table")
	public void user_should_find_email_in_the_search_table() {
		boolean status = customersPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true,status);
	}
	
	// Search by Name
	
	@When("User enters customer FirstName and LastName")
	public void user_enters_customer_first_name_and_last_name() {
		customersPage = new CustomersPage_POM(driver);
		customersPage.enterFullName("Victoria", "Terces");
	}
	@Then("User should find FullName in the Search table")
	public void user_should_find_full_name_in_the_search_table() {
		boolean status = customersPage.searchCustomerByFullName("Victoria" , "Terces");
		Assert.assertEquals(true,status);
	}

}




