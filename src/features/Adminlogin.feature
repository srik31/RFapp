Feature: Admin login functionality
  


Scenario: Login with Valid credentials
  Given I want to be on the Ranford page
  When  I enter the Username and Passwd 
  And   I click the login button
  Then  I navigate to the Homepage
 