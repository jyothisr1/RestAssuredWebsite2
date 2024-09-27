Feature: Validate create resource end point
  Scenario: Verify user can create resource
    Given user wants to call "/posts" end point
    And set header type "Content-Type" to "application/json"
    And set request body from the file "create_resource.json"
    When user perform post call
    Then verify user status is 201
    And verify id is not empty
    And user stores created booking id into "created.id";
    When user wants to call "/posts/@id" end point
    And set header type "Content-Type" to "application/json"
    And set request body from the file "create_token.json"
    And  user perform post call
    Then verify status code is 200