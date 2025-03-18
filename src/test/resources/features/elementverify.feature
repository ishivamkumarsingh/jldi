Feature: Verify Element Displayed Example

  Scenario: Hide the text field and verify it is not visible
    Given I launch Practice page
    When I click on the Hide button
    Then The text field should not be visible
