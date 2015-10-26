Feature: Admin dashboard presentation feature

In order to manage the service aggregator detials as an admin user 
I want to have a dashboard to perform tasks like accounting system for each service aggregator,activation/deactivation of a service aggregator,list of service aggregators registered and their payment reports,revenue details
and service aggregator profile management

#This feature file includes options that display in the admin user dashboard and their navigations

  Background:
    Given I am logged in as Admin User

  Scenario: Validate Status of Service Aggregator
    Given I click on the dashboard button link
    When I see the status of Service Aggregator
    Then It should be able available in appropriate colour

  Scenario: Validate Service Vendor List and New Request link
    Given I click on the dashboard button link
    When I click on Service Vendor List and New Request link
    Then I should be redirected to Service Vendor List and New Request page


  Scenario: Validate Service Vendor Profile and Analytics link
    Given I click on the dashboard button link
    When I click on Service Vendor Profile and Analytics link
    Then I should be redirected to Service Vendor Profile and Analytics page

  Scenario: Validate Money Analytics link
    Given I click on the dashboard button link
    When I click on Money Analytics menu bar
    Then I should see following sub menu fields:Payments-In,Payments Pending

  Scenario: Validate Profile Management menu bar
    Given I click on the dashboard button link
    When I click on Profile Management menu bar
    Then I should see following sub menu links: Contact Information,Enrollment Model Setup,Industry and Business Setup,Brand Management,Payment Gateway Setup,App Management

  Scenario: Validate App Management sub menu bar
    Given I click on the dashboard button link
    When I click on App Management sub menu bar of Profile Management menu bar
    Then I should see following sub menu links: Template Library,Website Page,Mobile Apps


  Scenario: Validate Mobile Apps sub menu bar
    Given I click on the dashboard button link
    When I click on Mobile Apps sub menu bar of App Management sub menu bar
    Then I should see following sub menu links: Custome Apps Template & Flow,Service Apps Template & Flow
    
   Scenario: Dasboard content display for an admin user
	   When Given I click on the dashboard button link
	   Then Dashboard should be displayed with a side menubar with below menu <MenuItem>
	   
	   Example:
	   | MenuItem                                 |       
	   | Service Aggregators List	                |
	   | Revenue Details							            |
	   | Profile Management						            |
	   | Money Analyser							              |
	   | Payment Reports							            |
	   | Activate/Deactivate service aggregator	  |
	   | Accounting system						            |
	
Scenario Outline: Verifaction of Pages when we click on Menu Item	
	   When Given I click on the dashboard button link
	   And User selected <MenuItem> from the side menubar
	   Then <Page> should be displayed
	
	|		MenuItem		         	|			Page					            |
	|	Service Aggregator List |	Service Aggregator List Page	|
	|	Revenue Details			    |	Revenue  Details Page			    |
	|	Profile Management		  |	Profile Management Page			  |
	|	Money Analyser			    |	Money Analyser Page				    |
	|	Payment Reports			    |	Payment Reports Page			    |
	|	Activate/Deactivate SA	| 	Activate/Deactivate SA Page	|
	|	Accounting System		    |	Accounting System Page			  |
	
