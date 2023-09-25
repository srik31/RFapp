Feature: Create a new Role

Scenario: Add a new roles with multiple sets of data
	Given I am on Ranford page
	When  I login with "Admin" and "TestingMindq"
	And   I click on the login button 
	Then  I naviagte to Home page
	When  I click on the Role button
#	And   I click on the New Role button
	And   I enter the New Role details
	|   RoleName				|	RoleType |
	| MarketingManager  |     E    |
	| ServiceManager    |     E    |	
	| BuisnessAnalyst   |     E    |
#	And   I click on the Submit button
#	Then  I see the required message after role creation
	And   I am back to Home page
	And   I logout of the application


# Use scenario and test data in between the step without using example

#Scenario: Add a new roles with multiple sets of data
#	Given I am on Ranford page
#	When  I login with "Admin" and "TestingMindq"
#	And   I click on the login button 
#	Then  I naviagte to Home page
#	When  I click on the Role button
#	And   I click on the New Role button
#	And   I enter the New Role details
#	| MarketingManager  |     E    |
#	And   I click on the Submit button
#	Then  I see the required message after role creation
#	And   I am back to Home page
#	And   I logout of the application
#	
	
	
#Scenario Outline: Add a new roles with multiple sets of data
#	Given I am on Ranford page
#	When  I login with "Admin" and "TestingMindq"
#	And   I click on the login button 
#	Then  I naviagte to Home page
#	When  I click on the Role button
#	And   I click on the New Role button
#	And   I enter the "<Rolename>" and "<Roletype>"
#	And   I click on the Submit button
#	Then  I see the required message after role creation
#	And   I am back to Home page
#	And   I logout of the application
#	
 #Examples: 
      #| Rolename  | Roletype |
      #| Mechanic  |     E    |
      #| Server    |     C    |
#			| HRManager |     E    |
#				