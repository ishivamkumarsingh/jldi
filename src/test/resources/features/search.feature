Feature: User Ssearches using search box
Scenario: User searches for "selenium" courses
    Given I open the All Courses page
    When I enter "selenium" in the course search box
    And I press enter or click the search icon
