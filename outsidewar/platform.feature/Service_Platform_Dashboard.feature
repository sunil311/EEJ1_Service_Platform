Feature:
  As an Service Aggregator Admin User
  I want to go to dashboard page
  So that I can access all menu and side bar available on Dashboard Page

  Background:
    Given I am logged in as Service Aggregator Admin User

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
