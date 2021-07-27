Feature: Create Individual

  @CreateIndividual @SmokeTest
  Scenario: Create an Individual with required fields
    Given I go to the new Individual formular
    When I set the lastname "Paul"
    Then The Individual's name is displayed in the header
