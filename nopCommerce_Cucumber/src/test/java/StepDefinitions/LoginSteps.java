package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.HomePage_POM;
import pages.Login_POM;

public class LoginSteps {
	WebDriver driver;
	Login_POM login;
	HomePage_POM homePage;
	// Background
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		String userdir = System.getProperty("user.dir");
		System.out.println(userdir);
		System.setProperty("webdriver.chrome.driver", userdir+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}
	@Then("User is navigated to Login page")
	public void user_is_navigated_to_login_page() {
		driver.getPageSource().contains("Welcome, please sign in!");
	}
	// Scenario steps
	@When("^User enters valid (.*) and (.*)$")
	public void user_enters_valid_admin_yourstore_com_and_admin(String email, String password) {
		login = new Login_POM(driver);
		login.enterEmail(email);
		login.enterPassword(password);
	}
	@And("Clicks on Login")
	public void clicks_on_login() {
		login.clickLogin();
	}
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}
	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
		homePage = new HomePage_POM(driver);
		homePage.clickLogout();
	}
	@Then("Close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}

}
