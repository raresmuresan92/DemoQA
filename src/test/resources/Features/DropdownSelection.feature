# Author: Rares Muresan
# Date: 05/23/2024
Feature: Dropdown selection verification

  Scenario: User selects a term from a dropdown list and verifies the selection
    Given user is on the elements page
    When user selects the 'Text Box' tab
    Then the selected term should be 'Text Box' tab
