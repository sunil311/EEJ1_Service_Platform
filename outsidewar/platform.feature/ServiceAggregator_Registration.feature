Story: ServiceAggregator Registration

Feature: 
  As a new User 
  I want to create a new user type as Service Aggregator to the site
  So that I can share my profile with other Service Aggregator's

Background: 
   Given Service Aggregator is on Registration Page

Scenario: Successful Service Aggregator Registration with valid data
          Given Servie Aggregator enters valid FirstName,LastName,Password,Email,MobileNumber
          When I clicked on Submit Button
          Then Message displayed Registration successful

Scenario Outline: Check Service Aggregator’s login credentials
          Given I filled <firstname><lastname><password><email><mobileno>
          When I clicked on Login
          Then I should see <success or failure> message 

          Examples: Valid login
          |firstname   |lastname |password |email            |mobileno   |success or failure|
          |Andy        |abc      |abcd1234 | andy@gmail.com  |9988776655 |success |
          |Mike        |xyz      |abcd1234 | mike@gmail.com  |8877665544 |success |


          Examples: InValid login
           |firstname   |lastname |password |email            |mobileno   |success or failure|
           |Andy        |abc      |         | andy@gmail.com  |9988776655 |success |
