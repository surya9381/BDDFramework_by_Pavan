Feature: Login functionalities

Background: Below are the common steps for each scenario
Given User launches the browser
When User open url "https://admin-demo.nopcommerce.com/login"

@sanity @regression @e2e
Scenario: Perform login action with valid creds
When User enters username as "admin@yourstore.com" and password as "admin"
And User clicks on login button
And wait for few seconds
And user click on logout 
And close browser

@surya
Scenario Outline: perform login action with diff sets of data
When User enters username as "<username>" and password as "<password>"
And User clicks on login button
And wait for few seconds
And user click on logout 
And close browser

Examples:
| username | password |
| admin@yourstore.com | admin |





