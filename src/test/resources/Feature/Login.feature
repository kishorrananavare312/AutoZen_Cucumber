Feature: User Login

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid email and password
    And clicks on the Login button
    Then User should be navigated to My Account page