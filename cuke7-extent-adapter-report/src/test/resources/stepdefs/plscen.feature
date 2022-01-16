# language: pl
@dialect
Właściwość: Polish Założenia Scenariusz And Szablon scenariusza 

  Szablon scenariusza: Scenario Outline Row <row_num>
    Zakładając, że Write a 'given' step with precondition in '<scenario_num><row_num>'
    Kiedy Complete action in 'when' step in '<scenario_num><row_num>'
    Wtedy Validate the outcome in 'then' step in '<scenario_num><row_num>'

    Przykłady: Odd number prefix
      | scenario_num         | row_num |
      | Scenario Outline One |     300 |
      | Scenario Outline Two |     500 |

    Przykłady: Even number prefix
      | scenario_num         | row_num |
      | Scenario Outline One |     400 |
      | Scenario Outline Two |     600 |

  Scenariusz: Scenario Number Seven Seven Seven
    Zakładając Write a 'given' step with precondition in 'Scenario 777'
    Kiedy Complete action in 'when' step in 'Scenario 777'
    Wtedy Validate the outcome in 'then' step in 'Scenario 777'
