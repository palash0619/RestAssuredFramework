Feature: Place API validations

@Addplace
Scenario Outline: Validate Add PLace API
Given Add place payload "<name>" "<language>" "<address>"
When user calls "addPlaceApi" with "Post" http request
Then Validate Statuscode 200
And Status is OK
Examples:
|name|language|address|
|Palash|English|kolkata|
|Poulami|Bengali|Kolkata|

