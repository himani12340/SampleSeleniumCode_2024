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


@MouseActions
Scenario: Perform mouse Actions
Given User launched the site
When user drag and drops the icon from source to the destination
Then the Dropped Items list shows the icon

@KeyboardEvent
Scenario: Perform Keyboard Actions
Given user launches the site for keyboard actions
When user enters username and password using keyboard actions
Then user extracts username and prints on console and then clicks on submit button
And prints the success message 


@Image
Scenario: 
Given 
When
Then 