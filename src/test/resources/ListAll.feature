Feature: List Subscribers
  Scenario:
    Given I have signed up to the email list
    When I load the list subscribers page
    Then I should see my email address