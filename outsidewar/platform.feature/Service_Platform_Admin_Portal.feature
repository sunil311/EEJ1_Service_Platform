Feature: Admin Portal features
  As a sysadmin User
  I want to have an admin portal in which drop down list of deactivate service aggregator should be present
  So that I can activate service aggregator from drop down list and email should be sent to an activated service aggregator

  Background:
    Given I am logged on as syadmin with user name:"sysadmin@sp.com",password:"admin"
    And I am on dashboard of Admin Portal

  Scenario: Validate correct data is listed in Deactivate Drop Down list
    When I view Deactivate Aggregator Drop Down list
    Then I verify correct data should be listed in Deactivate Drop Down list

  Scenario: Validate correct data is listed in pop up when we select any deactivate service aggregator
    When I view one deactivated service aggregator from Deactivate Aggregator Drop Down list
    Then I verify following data should be listed in pop up:DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL

  Scenario: Verification of  Deactivate Service Aggregator
    Given I view one deactivated service aggregator from Deactivate Aggregator Drop Down list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL is listed on pop up
    When I press the submit button
    Then I verify from the drop down list remembered service aggregator is not available in the list
   
  Scenario: Webservice Verification
    Given I view one deactivated service aggregator from Deactivate Aggregator Drop Down list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL is listed on pop up
    And I press the submit button
    When I view database by DatabaseName 
    Then I verify correct remembered DatabaseUserName,DatabasePassword,DatabaseURL is listed on the database table
   
  Scenario:Activate Service Aggregator from Webservices
    Given I view one deactivated service aggregator from Deactivate Aggregator Drop Down list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL is listed on pop up
    And I press the submit button
    When I view database by DatabaseName 
    Then I verify correct remembered DatabaseUserName,DatabasePassword,DatabaseURL is listed on the database table
    And I verify service aggregator status to be active in data base table
    
  Scenario: Email verification for activation of service aggregator and 
    Given Sysadmnin activated service aggregator
    When Service aggregator view inbox by using email Id provided by him during registartion
    Then Service aggregator view an e-mail in which zipped download template is available
    
     

