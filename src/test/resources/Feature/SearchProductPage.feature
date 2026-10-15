Feature:Search Product Page

  Scenario: Verify correct search product
    Given User is on the homepagee
    When User enters iMac procuctname
    And clicks on the Search button
    Then iMac product should be displayed