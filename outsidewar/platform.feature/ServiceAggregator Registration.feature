Feature : Service Aggregator Registration Feature
Description: This feature will test service aggregator registration functionality

Background: 
   Given ServiceAggregator is on Registration Page

Scenario: Successful Service Aggregator Registration with valid data
          Given Servie Aggregator enters valid FirstName,LastName,Password,EmailID,MobileNumber
          When I clicked on Submit Button
          Then Message displayed Registration successful

Scenario Outline: Check ServiceAggregator’s login credentials
          Given I filled <firstname><lastname> <email> and <password>
          When I clicked on Login
          Then I should see <success or failure> message 

          Examples: Valid login
          |firstname||lastname |email           |password |success or failure|
          |Andy     |abc       |andy@gmail.com  |abcd1234 |success |
          |Mike     |xyz       |mike@gmail.com  |abcd1234 |success |

          Examples: InValid login
          |firstname |lastname|email         |password |success or failure |
          |Andy      |abc      |andy@gmail.com|         |failure |
