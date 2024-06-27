Feature: Login Feature

  Scenario Outline: LG-01 LOGIN
    Given User opens Silabo application
    And User clicks on the initial login button
    When User enters "<email>" and "<password>"
    And User clicks on the submit button
    Then Application displays successful login message

    Examples:
      | email   | password |
      | admin@silaboe.com    | admin123 |