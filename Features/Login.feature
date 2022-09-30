Feature: Login Feature
  Verify if user is able to Login in to the site

  Scenario Outline: Login with incorrect credentials,
    Given user is on homepage
    And user navigates to Login Page
    When user fill username <username> and password <password>
    Then success message is displayed
    Examples:
      |username|password|
      |accountexist@yopmail.com|"Test"|
      |test@yopmail.com|"Test1234"|

  @Ready
  Scenario: Login with correct credentials,
    Given user is on homepage
    And user navigates to "Login" Page
    When user fill username "correct@yopmail.com" and password "Test1234"
    Then success message is displayed
