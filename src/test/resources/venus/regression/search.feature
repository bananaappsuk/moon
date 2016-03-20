
Feature: Search keyword

  Scenario Outline: Search with valid keywords and check results

    Given user is in search page
    When search by "<Keyword>"
    Then atleast 1 result should be shown
    And the result page should have keyword in it

    Examples:
    |Keyword|
    |Astronomy|
    |Astronomy Computer|
    |Astronomy's|
    |Maths 1    |
  @search
  Scenario Outline: Search with valid keywords and check results

    Given user is in search page
    When search by "<Keyword>"
    Then message "0 Result(s) for '"<Keyword>"'" should be shown
    And message "Sorry – we couldn’t find what you are looking for. Why not..." should be shown

    Examples:
      |Keyword|
      |Astronomysdsd|
      |Astronomysdsd|
      |Astronomysdsds|
      |Mathssdsd    |

