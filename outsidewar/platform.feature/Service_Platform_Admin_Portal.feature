Feature: Admin Portal features
  As a sysadmin User
  I want to have an admin portal in which drop down list of deactivate service aggregator should be present
  So that I can activate service aggregator from drop down list

  Background:
    Given I am logged on as syadmin with user name:"sysadmin@sp.com",password:"admin"
    And I am on Admin Portal

  Scenario: Validate correct data is listed in Deactivate Drop Down list
    When I view Deactivate Drop Down list
    Then I verify correct data should be listed in Deactivate Drop Down list

  Scenario: Validate correct data is listed in pop up when we select any deactivate service aggregator
    When I view one deactivated service aggregator from drop down list
    Then I verify following data should be listed in pop up:DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL

  Scenario: Activate Service Aggregator
    Given I view one deactivated service aggregator from drop down list
    And I verify correct DatabaseName,DatabaseUserName,DatabasePassword,DatabaseURL is listed on pop up
    When I press the submit button
    Then I verify from the drop down list remembered service aggregator is not available in the list

