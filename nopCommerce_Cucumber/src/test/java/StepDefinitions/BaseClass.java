package StepDefinitions;

import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pages.AddCustomerPage_POM;
import pages.CustomersPage_POM;
import pages.Login_POM;
import utils.WaitHelper;

public class BaseClass {
	// These objects needs to be instantiated before use
	public WebDriver driver;
	public AddCustomerPage_POM addCustomer;
	public Login_POM login;
	public CustomersPage_POM customersPage;
	public WaitHelper waitHelper;
	public static Logger logger; // to create logger msgs
	public Properties configProp; // to load config.properties  
	
	//Generates random string
	public static String generateRandomAlphabet() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(5);
		for (int i = 0; i < 5; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

}
