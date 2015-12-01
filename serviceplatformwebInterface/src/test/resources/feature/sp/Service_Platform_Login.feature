Feature: Login Feature
  As a existing User
  I want to log in to the site
  So that I can access all rights which are assigned

  Background:
    Given Existing user is on Login Page

  Scenario: Successful login with valid data
    Given I enter username and password with valid data
    When I clicked on login button
    Then I should be able to access all access rights assigned

  Scenario:Field length validation for User name (6-12 chars) and Password (6-12 chars)
    Given I enter username and password less than 6 or more than 12 alphanumeric value
    When I clicked on login button
    Then I should see proper message

  Scenario:Password field should be masked with asterisks (*****)
    When I enter password
    Then I should see in password in asterisks (*****)

  Scenario:Forgot Password link should be present on the form
      When I click on forgot password link
      Then I should be on reset-password page

  Scenario:Forgot Password Re-set functionality
    Given I click on forgot password link
    And I enter valid username or email-id
    When I press send email button
    Then i proper should come up

  Scenario: Successful logout from the site
    Given I enter username and password with valid data
    And I clicked on login button
    When I click on log out button
    Then I should be redirected to Login Page
