package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage_POM {
	protected WebDriver driver;
	
	public AddCustomerPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	
	@FindBy(id="Gender_Male")
	WebElement rdMale;
	
	@FindBy(id="Gender_Female")
	WebElement rdFemale;
	
	@FindBy(id="DateOfBirth")
	WebElement dateOfBirth;
	
	@FindBy(id = "Company")
	WebElement companyName;
	
	@FindBy(id = "IsTaxExempt")
	WebElement isTaxtExempt;
	
	@FindBy(xpath = "//li[contains(text(),'Your store name')]")
	WebElement newsletterSubs;
	
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement SelectedCustomerRoleGuest;
	
	@FindBy(id = "VendorId")
	WebElement vendorSelect;
	
	@FindBy(id = "AdminComment")
	WebElement adminComment;
	
	@FindBy(name = "save") 
	WebElement btnSave;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")
	WebElement delete;
	
	
	public void setEmailAndPswd(String email, String password) {
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void enterFullName(String firstName, String lastName ) {
		driver.findElement(txtFirstName).sendKeys(firstName);
		driver.findElement(txtPassword).sendKeys(lastName);
	}
	
	public void setGenderAndDate(String brdate) {
		rdMale.click();
		dateOfBirth.sendKeys(brdate);
	}
	
	public void enterCompName(String company) {
		companyName.sendKeys(company);
	}
	
	public void setSubscription() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", newsletterSubs);
		
	}
		
	
	public void setRole () throws InterruptedException { 
		delete.click();
		//WebElement guest = driver.findElement(By.xpath("//li[contains(text(),'Guests')]"));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", SelectedCustomerRoleGuest);
	}
	
	public void addComment(String comment) {
		adminComment.sendKeys(comment);
	}
	
	public void selectVendor() {
		Select dropdown = new Select(vendorSelect);
		dropdown.selectByValue("1");
	}
	
	public void clickSave() throws InterruptedException {
		btnSave.click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	

}
