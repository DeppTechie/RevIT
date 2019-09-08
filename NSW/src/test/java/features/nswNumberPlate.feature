Feature:  Apply for a number plate

@FunctionalTest
Scenario Outline: Matching Service Centre in a Suburb

Given I navigate to NSW website
When I apply for number plate
And I land at Apply for a number plate page correctly
When I enter the <desiredsuburb>
Then I find correct <servicecentrename>

     
  Examples: 
    |desiredsuburb   |servicecentrename | 
    |Sydney 2000     |Haymarket Service Centre|
   
    