Feature: Test Multiple Selenium Functionality
@Tag1
Scenario: Test Window Handling Functionality
Given user launches the url
When user clicks on Open New window Button
Then user navigates to child window and click on Form option
And Fills the Form and click on Submit and captures the Form Successfull message
And Close the child window and switch back to parent window

@Tag2
Scenario: Test Alert Handling Functionality
Given user launches the url
When user clicks on Open New Alert Button
Then user swicthes to Alert pop-up and captures the text message
And user accepts the alert 