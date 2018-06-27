Feature: EA login page
  To login to the EA Page

  Scenario Outline: Login to EA Page
    Given I browser the EA Login Page
    When I enter my correct "<userName>" and "<password>"
    And I click the login button
    Then I should be able to see "<message>"

    Examples: 
      | userName | password | message   |
      | name1    |        5 | User Form |
      | name2    |        7 | User Form |
