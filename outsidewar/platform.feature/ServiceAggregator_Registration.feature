Story: ServiceAggregator Registration

Feature: 
  As a new User 
  I want to create a new user type as Service Aggregator to the site
  So that I can share my profile with other Service Aggregator's

Background: 
   Given User is on Registration Page

Scenario: Successful Service Aggregator Registration with valid data
          Given Servie Aggregator enters valid FirstName,LastName,Password,Email,MobileNumber
          When I clicked on Submit Button
          Then Message displayed Registration successful

Scenario: Mandatory field First Name verfication in registration page
		  Given User is not filled First Name 
		  When User clicked on Submit button
		  Then User should see First Name is mandatory to create account message
		  
Scenario: Mandatory field Last Name verfication in registration page
		  Given User is not filled Last Name 
		  When User clicked on Submit button
		  Then User should see Last Name is mandatory to create account message		
		  
Scenario: Mandatory field password verfication in registration page
		  Given User is not filled password
		  When User clicked on Submit button
		  Then User should see password is mandatory to create account message
		 	
Scenario: Mandatory field email verfication in registration page
		  Given User is not filled email
		  When User clicked on Submit button
		  Then User should see email is mandatory to create account message	 
		  
Scenario: Mandatory field mobileno verfication in registration page
		  Given User is not filled mobileno
		  When User clicked on Submit button
		  Then User should see mobileno is mandatory to create account message

Scenario Outline: Check Service Aggregators login credentials
          Given I filled <firstname><lastname><password><email><mobileno><displayname><companyname><housenumber><locality><state><postcode><bankacctholdername><bankname><branchaddress><accountnumber><IFSCcode><plan><facebookurl><twitterurl><domainname><ServieAggregatorType>
          When I clicked on Submit
          Then I should see <success or failure> message
          
        Examples: Valid login
          |firstname   |lastname |password |email            |mobileno   |displayname	|companyname 	|housenumber	|locality	|state 		|postcode	|bankacctholdername	|bankname	|branchaddress	|accountnumber	|IFSCcode	|plan		|facebookurl			|twitterurl				|domainname			|ServiceAggregatorType	|success or failure|
          |Andy        |abc      |abcd1234 | andy@gmail.com  |9988776655 |Frshmenu		|Freshmenu		|1324			|M.G.Road	|Karnataka	|523101		|Freshmenu			|ICICI		|M.G.Road		|1234567890		|IC0000002	|fixcost	|www.facebook.com/test	|www.twitter.com/test 	|www.freshmenu.com 	|Food					|success |
          |Mike        |xyz      |abcd1234 | mike@gmail.com  |8877665544 |Cab Services|success |


        Examples: InValid login
           |firstname   |lastname |password 	|email            |mobileno   |displayname	|companyname 	|housenumber	|locality	|state 		|postcode	|bankacctholdername	|bankname	|branchaddress	|accountnumber	|IFSCcode	|plan		|facebookurl			|twitterurl				|domainname			|ServiceAggregatoreType	|success or failure|
           |Andy123     |abc      |abcd1234     | andy@gmail.com  |9988776655 |Frshmenu		|Freshmenu		|1324			|M.G.Road	|Karnataka	|523101		|Freshmenu			|ICICI		|M.G.Road		|1234567890		|IC0000002	|fixcost	|www.facebook.com/test	|www.twitter.com/test 	|www.freshmenu.com 	|Food					|success |
           

Scenario: Verify the contents of plan dropdown in service aggregator registration page
		  When User clicked on Plan drop down
		  Then dropdown should be shown with below items
		  Example: Plan dropdown contents
		  |fix cost 				|
		  |per transaction			|
		  |fixed monthly			|
		  |one time lump-sum payment|
 
