Feature: Admin dashboard presentation feature

In order to manage the service aggregator detials as an admin user 
I want to have a dashboard to perform tasks like accounting system for each service aggregator,activation/deactivation of a service aggregator,list of service aggregators registered and their payment reports,revenue details
and service aggregator profile management

#This feature file includes options that display in the admin user dashboard and their navigations

  Background:
    Given I am logged in as Admin User

   Scenario Outline: Dashboard content display for an admin user
	   When I am on the dashboard 
	   Then Dashboard should be displayed with a side menubar with below menu <MenuItem>
	   
	   Example:
	   | MenuItem                                 |       
	   | Service Aggregators List	              |
	   | Revenue Details		              |
	   | Profile Management		              |
	   | Money Analyser			      |
	   | Payment Reports			      |
	   | Activate/Deactivate service aggregator   |
	   | Accounting system			      |
	
Scenario Outline: Verifaction of Pages when we click on Menu Item	
	   When I am on the dashboard
	   And User selected <MenuItem> from the side menubar
	   Then <Page> should be displayed

        Example:
	|		MenuItem        |			Page		|
	|	Service Aggregator List |	Service Aggregator List Page	|
	|	Revenue Details	        |	Revenue  Details Page		|
	|	Profile Management	|	Profile Management Page		|
	|	Money Analyser		|	Money Analyser Page		|
	|	Payment Reports		|	Payment Reports Page		|
	|	Activate/Deactivate SA	| 	Activate/Deactivate SA Page	|
	|	Accounting System	|	Accounting System Page		|
	
