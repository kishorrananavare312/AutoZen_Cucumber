Feature: Account Registration

  Scenario: Verify new user account registration
    Given User is on the homepage
    When User clicks on My Account and selects Register option
    And User provides valid personal details
    And User accepts the privacy policy and submits the form
    Then A confirmation message "Your Account Has Been Created!" should be displayed