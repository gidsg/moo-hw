Feature: Email Signup
  Background:
    Given I am on the email sign up page

  @happypath
  Scenario: Sign up a new valid email address
    When I enter a valid email address
    Then I see a thank you confirmation message

  Scenario: Leave email field blank
    When I leave the email field blank
    Then I see an error message

  Scenario: Enter invalid email address
    When I enter an invalid email address
    Then I see an error message to provide a valid email address

  Scenario: Sign up with existing email address
    Given I sign-up as "gidsgoldberg@gmail.com"
    When I sign-up again as "gidsgoldberg@gmail.com"
    Then I see an error message saying the email address is already subscribed