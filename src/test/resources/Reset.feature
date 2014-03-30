Feature: Reset email list
  Scenario: Reset email list
    When I go to the reset URL
    Then I will see a confirmation message
    And there will be no email addresses on the email list