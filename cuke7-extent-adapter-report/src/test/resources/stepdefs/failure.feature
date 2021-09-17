@failure
Feature: Hook and step failures

  Scenario: Before Hook
    Given Hook failure step
    When Skip hook failure step

  Scenario: After Hook
    Given Hook failure step
    Then Skip hook failure step
