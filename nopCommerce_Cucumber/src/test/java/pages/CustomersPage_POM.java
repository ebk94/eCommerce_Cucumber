package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class CustomersPage_POM {
	
	WebDriver driver;
	WaitHelper waithelper;
	
	public CustomersPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}
	
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]")
	@CacheLookup
	WebElement customersMenu;
	
	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")
	@CacheLookup
	WebElement customersPage;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
	@CacheLookup
	WebElement newUser;
	
	@FindBy(id = "SearchEmail")
	WebElement txtEmail;
	
	@FindBy(id = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(id = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(id = "search-customers")
	@CacheLookup
	WebElement btn_search;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"customers-grid\"]")
	@CacheLookup
	WebElement table;
	
	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void clickCustomerMenu() {
		customersMenu.click();
	}
	
	public void navigateToCustomers() {
		customersPage.click();
	}
	
	public void addNewUser() {
		newUser.click();
	}
	
	// SeachCustomers
	
	public void enterEmail(String email) {
		waithelper.WaitForElement(txtEmail, 20);
		txtEmail.sendKeys(email);
	}
	
	public void enterFirstname(String firstName) {
		txtEmail.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		txtEmail.sendKeys(lastName);
	}
	
	public void clickSearch() {
		btn_search.click();
	}
	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		for(int i=1; i<getNoOfRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email)) {
				flag = true;
			}
		}
		return flag;
	} 
	
	// Search by Name
	
	
	public void enterFullName(String firstName, String lastName) {
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
	}
	
	public boolean searchCustomerByFullName(String Name, String LastName) {
		boolean flag = false;
		for(int i=1; i<getNoOfRows(); i++) {
			waithelper = new WaitHelper(driver);
			waithelper.WaitForElement(table, 10);
			String name = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(name);
			String names[]=name.split(" "); //separate fname and lname
			System.out.println(names[0]);
			if(names[0].equals(Name) && names[1].equals(LastName)) {
				flag = true;
			}
		}
		return flag;
	} 
	
}


