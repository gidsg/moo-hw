Feature: Email Signup
  Scenario: Sign up a new email address
    Given I am on the email sign up page
    When I enter a valid email address
    Then I see a thank you confirmation message