Feature:
  As a existing User
  I want to log in to the site
  So that I can access all rights which are assigned

  Background:
    Given Existing user is on Login Page

  Scenario: Successful login with valid data
    Given I enter username and password with valid data
    When I submit the login form 
    Then I should be able to access all access rights assigned

  Scenario:Field length validation for User name (6-12 chars) and Password (6-12 chars)
    Given I enter username and password less than 6 or more than 12 alphanumeric value
    When I submit the login form 
    Then I should see proper message

  Scenario:Password field should be masked with asterisks (*****)
    When I enter password
    Then I should see in password in asterisks (*****)

  Scenario:Forgot Password link should be present on the form
    When I view forgot password link
    Then I should be on reset-password page

  Scenario:Forgot Password Re-set functionality
    Given I am on Pasword Re-set form
    And I enter valid username or email-id
    When I submit the password re-set form
    Then Proper message should be displayed

  Scenario: Successful logout from the site
    Given I enter username and password with valid data
    And I submit the login form 
    When I log out from site
    Then I should be redirected to Login Page
