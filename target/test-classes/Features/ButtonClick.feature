# Author: Rares Muresan
# Date: 05/23/2024


Feature: Test dynamic button click functionality
	

  Scenario: Verify dynamic button click
  	Given browser is open
    And user is on the buttons page
    When user clicks on the 'Click Me' button
    Then the message 'You have done a dynamic click' should be displayed
