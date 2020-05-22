Feature: Functional Tests

  Background:
    * url baseUrl
    * def marsAPI = '/rest/mars'

  Scenario: RightRotation

    Given path marsAPI + '/MMRMMRMM'
    When method POST
    Then status 200
    And match response == "2, 0, S"

  Scenario: LeftRotation

    Given path marsAPI + '/MML'
    When method POST
    Then status 200
    And match response == "0, 2, W"

  Scenario: Repeat

    Given path marsAPI + '/MML'
    When method POST
    When method POST
    Then status 200
    And match response == "0, 2, W"

  Scenario: Invalid

    Given path marsAPI + '/MMMMMMMMMMMMMM'
    When method POST
    Then status 400