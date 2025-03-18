Feature: Handle alert in the practice page

  Scenario: Verify alert text after entering name
    Given I am on the Let's Kode It practice page
    When I enter "Shivam" in the alert textbox
    And I click on the alert button
    Then I should see an alert with message "Hello Shivam, share this practice page and share your knowledge"
