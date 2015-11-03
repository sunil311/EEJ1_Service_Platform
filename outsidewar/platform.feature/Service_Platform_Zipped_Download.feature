Feature: Service Aggregator Template Download feature

  In order to download the service aggregator template as service aggregator
  I want to have a download functionality on service aggregator details page
  So that we perform tasks like download zip template and unzip downloaded template

#This feature file includes options of downloading the service aggergator template

 Scenario: Validate Zipped Download Template Functionality
    Given I am logged in as Service Aggregator after successful registartion
    And  I on service aggregator details page
    When I click on Download Template Button
    Then I verify zipped template is downloaded on my system

 Scenario: Verify File format of zipped template(.zip)
    Given I am logged in as Service Aggregator after successful registartion
    And  I on service aggregator details page
    When I click on Download Template Button
    Then I verify file format of downlaoded zip file should be ".zip"

 Scenario: Validate Unzip Functionality
    Given I am on local machine
    And  I go the download folder
    When I unzip the downloaded template using zip or 7zip softawre
    Then I verify all the files,directories succesfully downloaded on the system
    
  Scenario: Validate all the functionality should work on server
    Given I am on local machine
    When I uploaded all files,directory structure on server
    Then I verify all the functionality available should work on server
