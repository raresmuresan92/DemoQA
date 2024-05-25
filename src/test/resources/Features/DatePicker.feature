Feature: Date Picker

  Scenario: Select a new date from the date picker
    Given user is on the date picker page
    When user selects a new date
    Then the selected date should change to the new date
