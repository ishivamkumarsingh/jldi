Feature: Verify All Courses Page Title

  Scenario: Navigate to All Courses and verify the title
    Given I navigate to the homepage
    When I navigate to the All Courses section
    Then The page title should be "All Courses"
