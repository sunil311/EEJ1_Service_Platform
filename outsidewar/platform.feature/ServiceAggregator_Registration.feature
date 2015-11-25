Feature: 
  As a new User 
  I want to create a new user type as Service Aggregator to the site
  So that I can share my profile with other Service Aggregator's

Background: 
   Given User is on Registration Page

Scenario: Successful Service Aggregator Registration with valid data
          Given I enters valid FirstName,LastName,Password,Email,MobileNumber,DisplayName,CompanyName,HouseNumber,Locality,State,Postcode,BankActHolderName,BankName,BranchAddress,AcctNumber,IIFSCCode,Plan,FacebookUrl,TwitterUrl,DomainName,ServiceAggregatorType
          When I submit the registration form
          Then I should be registered as New Service Aggregagtor

Scenario: Mandatory field First Name verification in registration page
          Given I filled all the required fields apart from FirstName
          When I submit the registration form
          Then I should see that I am not able to register as service aggregator with appropriate message
		  
Scenario: Mandatory field Last Name verification in registration page
          Given I filled all the required fields apart from Last Name
          When I submit the registration form
		  Then I should see that I am not able to register as service aggregator with appropriate message
		  
Scenario: Mandatory field password verification in registration page
          Given I filled all the required fields apart from password
          When I submit the registration form
          Then I should see that I am not able to register as service aggregator with appropriate message
		 	
Scenario: Mandatory field email verification in registration page
          Given I filled all the required fields apart form email
          When I submit the registration
          Then I should see that I am not able to register as service aggregator with appropriate message

Scenario Outline: Check Service Aggregators login credentials
          Given I filled <firstname><lastname><password><email><mobileno><displayname><companyname><housenumber><locality><state><postcode><bankacctholdername><bankname><branchaddress><accountnumber><IFSCcode><plan><facebookurl><twitterurl><domainname><ServiceAggregatorType>
          When I submit the registration form email
          Then I should see <success or failure> message
          
        Examples: Valid login
          |firstname   |lastname |password |email            |mobileno   |displayname	|companyname 	|housenumber	|locality	|state 		|postcode	|bankacctholdername	|bankname	|branchaddress	|accountnumber	|IFSCcode	|plan		|facebookurl			|twitterurl				|domainname			|ServiceAggregatorType	|success or failure|
          |Andy        |abc      |abcd1234 | andy@gmail.com  |9988776655 |Frshmenu		|Freshmenu		|1324			|M.G.Road	|Karnataka	|523101		|Freshmenu			|ICICI		|M.G.Road		|1234567890		|IC0000002	|fixcost	|www.facebook.com/test	|www.twitter.com/test 	|www.freshmenu.com 	|Food					|success |

        Examples: InValid login
           |firstname   |lastname |password 	|email            |mobileno   |displayname	|companyname 	|housenumber	|locality	|state 		|postcode	|bankacctholdername	|bankname	|branchaddress	|accountnumber	|IFSCcode	|plan		|facebookurl			|twitterurl				|domainname			|ServiceAggregatorType	|success or failure|
           |Andy123     |         |             | abc             |9988776655 |Frshmenu		|Freshmenu		|1324			|M.G.Road	|Karnataka	|523101		|Freshmenu			|ICICI		|M.G.Road		|1234567890		|IC0000002	|fixcost	|www.facebook.com/test	|www.twitter.com/test 	|www.freshmenu.com 	|Food					|success |
           

Scenario Outline: Verify the contents of plan in service aggregator registration page
		  When I view Plan in registration form
		  Then I should below <Plans> types
		  Examples: Plan contents
                  |Plans                                |
		  |fix cost 				|
		  |per transaction			|
		  |fixed monthly			|
		  |one time lump-sum payment|
 
