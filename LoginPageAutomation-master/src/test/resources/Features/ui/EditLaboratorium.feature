Feature: Edit Laboratory

  Scenario: ADM-02B Edit Laboratory (Positive)
    Given User signed as admin and in the laboratorium page
    And User opens laboratorium details
    And User clicks on the Edit button
    And User enters input edit laboratory name "test edit", description "test edit", and selects type "Gudang"
    And User clicks on the Edit Submit button
    Then User should see a success on editing message and the edited laboratory in the list