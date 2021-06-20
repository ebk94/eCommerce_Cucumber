#Author: botirbek.kulzhanov@gmail.com
Feature: Customers
	@sanity
  Scenario: Add new Customer
    Given user signed with valid credentials
    And user can view Dashboard
    When user clicks on customers Menu
    And clicks on customers Menu
    And clicks on Add new button
    Then user can view Add new customer page
    When user enters customer Info and saves
    Then user can view confirmation message "The new customer has been added successfully"
	
	@regression
  Scenario: Search customer
    Given User is signedIn
    When User clicks on customers Menu
    And User click on selects Customers
    And User enters customer Email
    When User clicks on search button
    Then User should find Email in the Search table
    
  @regression
  Scenario: Search customer by Name
    Given User is signedIn
    When User clicks on customers Menu
    And User click on selects Customers
    And User enters customer FirstName and LastName
    When User clicks on search button
    Then User should find FullName in the Search table

