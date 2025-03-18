Feature: Verify price on the Interview page

  Scenario: Fetch and verify the price on the Interview page
    Given I navigate to the interview page
    When I fetch the displayed price
    Then The price should be "From $4.99"
