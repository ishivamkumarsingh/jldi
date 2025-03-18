Feature: Header Section Verification

  @headerverification
  Scenario: Verify webpage title and major navigation sections
    Given I navigate to the application homepage
    Then The webpage title should be "Home Page"
    And The following navigation sections should be displayed
      | Home       |
      | ALL COURSES |
      | INTERVIEW   |
      | SUPPORT     |
      | BLOG        |
