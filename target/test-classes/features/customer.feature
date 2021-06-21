#Author: your.email@your.domain.com

@tag
Feature: Get customer details


  Scenario Outline: Fetch all customer details from API
    Given I have a API endpoint to fetch all customer details and get the response
    When I fetch the customer ID received and append it to the endpoint 
    Then I get the valid customer response
    And I send incorrect customer ID I get error response

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

