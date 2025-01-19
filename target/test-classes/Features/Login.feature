Feature: verify OMR Branch login Module

  @Login1
  Scenario Outline: verify OMR Branch login with valid credentials
    Given user is on the OMR Branch page
    When user enters "<username>" and "<password>"
    And users click the login button
    Then user should verify after login success message

    Examples: 
      | username             | password    |
      | crshahul11@gmail.com | shahuL@1991 |

  @Login2
  Scenario Outline: verify OMR Branch login with valid credentials
    Given user is on the OMR Branch page
    When user enters "<username>" and "<password>"
    And users click the login button
    Then user should verify after login success message

    Examples: 
      | username             | password    |
      | crshahul11@gmail.com | shahuL@1991 |

  @Login3
  Scenario Outline: verify OMR Branch login with valid credentials
    Given user is on the OMR Branch page
    When user enters "<username>" and "<password>"
    And users click the login button
    Then user should verify after login success message

    Examples: 
      | username             | password    |
      | crshahul11@gmail.com | shahuL@1991 |
