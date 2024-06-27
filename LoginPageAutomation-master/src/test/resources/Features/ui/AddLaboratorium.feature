Feature: Create Laboratory

  Scenario: ADM-02B Create Laboratory (Positive)
    Given User signed as admin
    And User navigates to the dashboard
    And User goes to the laboratory page
    And User opens the add laboratory form
    And User enters laboratory name "test", description "test", and selects type "Laboratorium"
    And User clicks on the Submit button
    Then User should see a success message and the new laboratory in the list