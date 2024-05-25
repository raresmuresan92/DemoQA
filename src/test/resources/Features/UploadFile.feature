Feature: File Upload

  Scenario: Upload a file from project structure
    Given user is on the upload page
    When user uploads the file
    Then the file should be uploaded successfully
