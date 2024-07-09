Feature: Test Selenium Easy Demo Site

@Tag1
Scenario: Test Input Forms on Demo Site
Given user launches the site
When user clicks on Input Forms Link
And user navigates to Select Drop Down List option
And user selects Sunday from the select a day list 
And user selects California from multi Select List

@Tag2
Scenario: Filling Input Form and Submiting it
Given user is on Input Form Page
When user enters "<firstname>" , "<lastname>", "<email>", "<PhoneNumber>", "<Address>", "<City>"
And Selects "<State>"and enters "<ZipCode>", "<Website>"
And Select option for Hosting 
And enters project description as "Testing Purpose"
And Click on Send button 

@Tag3
Scenario: Date picker functionality check
Given user is on HomePage and navigates to Date Picker option
When user clicks on datepicker
And Selects the date from the calender
Then Date should appear in the text box successfully


