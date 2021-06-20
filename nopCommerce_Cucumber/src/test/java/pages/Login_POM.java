package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POM {
	
	WebDriver driver;
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement txt_email;
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(css = "body > div.master-wrapper-page > div > div > div > div > div.page-body > div.customer-blocks > div > form > div.buttons > button")
	@CacheLookup
	WebElement btn_login;
	
	
	public Login_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		txt_email.clear();
		txt_email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	

}
