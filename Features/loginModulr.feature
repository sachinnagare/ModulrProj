Feature: feature to test login functionality

  Background: 
    Given user is on login page

  Scenario: Validate error message while login with empty username and password.
    When user do not enter any value into username and password and click on login button
    Then an adequate error message should be shown

     Scenario: Incorrect Password should show an adequate error message
    When user enters password however do not enter username
    And click on login button
    Then an adequate warning message should be displayed
    
@smoke
  Scenario: Incorrect Username should show an adequate error message
    When user enter incorrect username and password
    And click on login button
    Then an adequate warning message should be displayed
    
@smoke
  Scenario: Successful login should take the user to the account overview page
    When user enter valid username and password
    And click on login button
    Then user redirect to Account page
    
      Scenario: The user should have the ability to reset their password
    When click on Forgotten password link
    And enter username to reset password
    And click on Request a reset button
    Then Email Sent popup should be displayed
    

    
 
    
    
    
    