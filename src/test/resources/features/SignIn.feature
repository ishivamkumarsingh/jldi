Feature: User Sign-In Functionality

  @SignIn
  Scenario Outline: User attempts to sign in
    Given I open the application home page
    When I click on the "Login" link
    And I enter username "<username>" and password "<password>"
    Then I should see "My Courses" as the login outcome

    Examples:
      | username       | password     |
      | zoi@gmail.com  | qwerty12345@ |
