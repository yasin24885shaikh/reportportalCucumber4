Feature: Belly1

  @ok
  Scenario: a few cukes1
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl
