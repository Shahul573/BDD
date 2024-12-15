Feature: verify amazon login module

  Scenario: validating login with invalid username and valid password
    Given user is on the amazon page
    When user enter invalid user name and valid password
    And user click the login button
    Then validate the homepage

  Scenario: validating login with valid username and invalid password
    Given user is on the amazon page
    When user enter valid user name and invalid password
    And user click the login button
    Then validate the homepage

  Scenario: validating login with invalid username and invalid password
    Given user is on the amazon page
    When user enter invalid user name and invalid password
    And user click the login button
    Then validate the homepage

  Scenario: validating login with valid username and valid password
    Given user is on the amazon page
    When user enter valid user name and valid password
    And user click the login button
    Then validate the homepage
