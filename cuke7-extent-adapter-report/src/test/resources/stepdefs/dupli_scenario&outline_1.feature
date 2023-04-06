@duplicate
Feature: Duplicate Scenario And Scenario Outline

  Scenario Outline: Duplicate SO Row <row_num>
    SO Row Description

    Given Write a 'given' step with precondition in '<scenario_num><row_num>'
    When Complete action in 'when' step in '<scenario_num><row_num>'
    Then Validate the outcome in 'then' step in '<scenario_num><row_num>'

    Examples: Numbers
      | scenario_num         | row_num |
      | Scenario Outline One |     100 |
      | Scenario Outline Two |     900 |

  Scenario Outline: Duplicate SO Row <row_num>
    SO Row Description

    Given Write a 'given' step with precondition in '<scenario_num><row_num>'
    When Complete action in 'when' step in '<scenario_num><row_num>'
    Then Validate the outcome in 'then' step in '<scenario_num><row_num>'

    Examples: Numbers
      | scenario_num         | row_num |
      | Scenario Outline One |     600 |
      | Scenario Outline Two |     200 |

  Scenario: Duplicate Scenario Number Seven
    Given Write a 'given' step with precondition in 'Scenario 777'
    When Complete action in 'when' step in 'Scenario 777'
    Then Validate the outcome in 'then' step in 'Scenario 777'
