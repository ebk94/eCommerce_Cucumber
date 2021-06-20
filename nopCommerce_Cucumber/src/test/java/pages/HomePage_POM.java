package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_POM {
	
	WebDriver driver;
	
	@FindBy(css = "#navbarText > ul > li:nth-child(3) > a")
	WebElement btn_logout;
	
	public HomePage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLogout() {
		btn_logout.click();
	}
}
