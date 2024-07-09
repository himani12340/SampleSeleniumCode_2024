Feature: Login Swag Labs application
Desription: Purpose to login application

@First
Scenario: Demo Application
Given User launches the Swag Labs Application
When User "standard_user" and "secret_sauce" and click on Login button
Then User should be succesfully logged in the application


@Second
Scenario Outline: Swag Labs Application using different <username> and <password>
Given User loads the Swag Labs Application
When User enters "<username>" and "<password>" and clicks on Login button
And User is succesfully logged into the Swag Labs application
And Select the product "Sauce Labs Backpack" and click on AddCart
And user should be able to add produt to the cart
And AddCart button should change to Remove button
Then the functionality is tested successfully

Examples:
    | username   | password |
    | standard_user | secret_sauce |
    | visual_user | secret_sauce |
    
    
@First @Second
Scenario: Demo Application
Given User launches the Swag Labs Application
When User "standard_user" and "secret_sauce" and click on Login button
Then User should be succesfully logged in the application
