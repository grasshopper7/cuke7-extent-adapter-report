@both @device_Iphone5 @author_Arthur
Feature: Scenario And Scenario Outline

  Background: 
    Given Hello background

  @scenout @device_Iphone @author_Christie
  Scenario Outline: SO Row <row_num>
    SO Row Description

    Given Write a 'given' step with precondition in '<scenario_num><row_num>'
    When Complete action in 'when' step in '<scenario_num><row_num>'
    Then Validate the outcome in 'then' step in '<scenario_num><row_num>'

		@odd @dev_SE @dev_
    Examples: Odd number prefix
      | scenario_num         | row_num |
      | Scenario Outline One |     300 |
      | Scenario Outline Two |     500 |

		@even @aut_Agatha @aut
    Examples: Even number prefix
      | scenario_num         | row_num |
      | Scenario Outline One |     400 |
      | Scenario Outline Two |     600 |

  @scen @dev_Samsung @aut_Enid
  Scenario: Scenario Number Seven Seven Seven
    Given Write a 'given' step with precondition in 'Scenario 777'
    When Complete action in 'when' step in 'Scenario 777'
    Then Validate the outcome in 'then' step in 'Scenario 777'

  @misc
  Scenario: Scenario Other Symbols
    * Write a 'given' step with precondition in 'Scenario 777'
    And Complete action in 'when' step in 'Scenario 777'
    But Validate the outcome in 'then' step in 'Scenario 777'
