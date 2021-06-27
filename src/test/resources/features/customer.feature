#Author: profile.kumarkrish@gmail.com

@tag
Feature: Get customer details

  
  Scenario: Getting all customer details 
    Given I have a GET API URI to fetch customer details
    When I append the end point specific to fetching all the customer details
    And I check for the response status code
    And I check the response time

 
    
  Scenario: Getting specific customer details
    Given I have a GET API URI to fetch customer details
    And I have fetched the list of valid customer IDs
    When I append the specific customer ID as the end point
    And I check for the response status code
    And I check the response time

    
  Scenario: Assert the values of different APIs  
    Given I have a GET API URI to fetch customer details
    When I have collected both the complete and individual customer details
    And I check for the response status code
    And I check the response time
    Then I assert the values to check if the match or not

  Scenario: Checking the API response for incorrect customer ID
    Given I have a GET API URI to fetch customer details
    And I have fetched the list of valid customer IDs
    When I append the specific customer ID which is not valid as the end point
    And I check for the response status code
    And I check the response time

    


