Feature: verify OMR Branch login Module

  Scenario Outline: verify OMR Branch login with valid credentials
    Given user is on the OMR Branch page
    When user enters "<username>" and "<password>"
    And users click the login button
    Then user should verify after login success message

    Examples: 
      | username             | password    |
      | crshahul11@gmail.com | shahuL@1991 |
      | Bala@gmail.com       | Hello@12345 |
      | Mani@gmail.com       | Hello@12    |

 