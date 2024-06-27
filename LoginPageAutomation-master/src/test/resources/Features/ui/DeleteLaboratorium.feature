Feature: Delete Laboratory

  Scenario: ADM-02B Delete Laboratory (Positive)
    Given User signed as admin and in the laboratorium details page
    And User clicks on the Delete button
    Then User should see a success message and the laboratory is deleted