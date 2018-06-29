Feature: EA Home page
   to the EA Home Page

  Scenario Outline: on to EA Home Page
    Given I am on the EA HOME PAGE for "<userName>" and "<password>"
    When I fill in user form as "<title>", "<initial>", "<firstName>", "<middleName>"
    And I click the save button

    Examples: 
      | userName | password | title | initial | firstName | middleName |
      | name1    |        5 | Mr.   | S       | Singh     | Jhinjer    |
      | name2    |        7 | Ms.   | Y       | Kaur      | Chauhan    |
