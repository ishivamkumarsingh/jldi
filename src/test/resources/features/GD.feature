Feature: Enter account details from Excel

  Scenario: Fill account form using test data from Excel
    Given I navigate to the account page
    When I enter email "zoi@gmail.com" and password "qwerty12345@"
    And I click on the login button
    And I wait for the form to load
    And I fill the address and zip code using "AccountTestData.xlsx" sheet "Sheet1"
    And I click on the update button
    Then The update should be successful
