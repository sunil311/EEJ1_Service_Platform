Feature: Admin Portal features
  As a sysadmin User
  I want to have a dashboard pn admin portal in which drop down list of deactivate service aggregator should be present
  So that I can activate service aggregator from drop down list and email should be sent to an activated service aggregator

  Background:
    Given I am logged on as syadmin with user name:"sysadmin@sp.com",password:"admin"
    And I am on dashboard of Admin Portal

  Scenario: Validate correct data is listed in Deactivate Aggregator list
    When I want to view Deactivate Aggregator list
    Then I verify correct data should be listed in Deactivate Aggregator list

  Scenario: Validate correct data is viewed when we select any deactivate service aggregator from list
    When I view one deactivated service aggregator from Deactivate Aggregator list
    Then I should see following elements:DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL

  Scenario: Verification of  Deactivate Service Aggregator
    Given I view one deactivated service aggregator from Deactivate Aggregator list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL are listed
    When I activate remembered deactivated service aggregator from Deactivate Aggregator list
    Then I should not see activated service aggregator is listed in the list
   
  Scenario: Webservice Verification
    Given I view one deactivated service aggregator from Deactivate Aggregator list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL are listed
    And I activate remembered deactivated service aggregator from Deactivate Aggregator list
    When I see view database by DatabaseName 
    Then I verify correct remembered DatabaseUserName,DatabasePassword,DatabaseURL is listed on the database
   
  Scenario:Activate Service Aggregator status on database
    Given I view one deactivated service aggregator from Deactivate Aggregator list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL are listed
    And I activate remembered deactivated service aggregator from Deactivate Aggregator list
    When I see view database by DatabaseName
    Then I verify correct remembered DatabaseUserName,DatabasePassword,DatabaseURL is listed on the database
    And I verify service aggregator status to be active
    
  Scenario: Email verification for activation of service aggregator
   Given Sysadmnin activated service aggregator from admin dashboard
    When Activated Service aggregator view an email which will be sent by sysadmin
    Then Service aggregator view an e-mail in which zipped download template is available as an attachment
  
  Scenario: Zipped Template Download via Email 
   Given Sysadmnin activated service aggregator from admin dashboard
    And Activated Service aggregator view an email which will be sent by sysadmin
    When Service aggregator download the attachment from email
    Then Zipped Template should be downloaded on respective directory
  
  
    
     

