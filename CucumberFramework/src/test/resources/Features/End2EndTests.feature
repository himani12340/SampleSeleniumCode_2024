Feature: Tesing Functionalities

@WindowHandling
Scenario Outline: Test Window Handling Functionality
Given user launches the Window Popup url
When user clicks on Click Here link
Then user navigates to child window , enter the "<email id>" , click on submit button and captures the data

Examples:
|email id|
|abcd@gmail.com|
|hello@yahoo.com|

@Alert
Scenario: Test Alert Handling Functionality
Given user launches the url to test Alert functionality
When user enters the customerID "123456" and click on Submit button
Then user swicthe to Alert pop-up and captures the text message
And user accepts the alert 

@Tooltip
Scenario: Verify tooltip
Given user launches the url to test tooltip functionality
When user hovers the mouse over the icon 
Then user captures the tooltip message 

@Image
Scenario: 
Given 
When
Then 