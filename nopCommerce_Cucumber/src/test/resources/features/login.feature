#Author: botirbek.kulzhanov@gmail.com
Feature: Login

  Background: Open browser and go to URL
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    Then User is navigated to Login page
	@regression
  Scenario Outline: Sucessful Login with Valid Credentials
    When User enters valid <email> and <password>
    And Clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page title should be "Your store. Login"
    And Close browser

    Examples: 
      | email                 | password |
      | admin@yourstore.com   | admin    |
      | admin@yourstore.com   | admin123 |
      | admin22@yourstore.com | admin    |
