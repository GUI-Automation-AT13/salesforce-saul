Feature: Create Individual

  @CreateIndividual @RegressionTest
    Scenario Outline: Create a Salesforce Individual object
    Given I navigate to the new Individual page
    When I create a new Individual record with the following parameters
      | salutation                | <salutation>                |
      | lastname                  | <lastname>                  |
      | firstname                 | <firstname>                 |
      | birthdate                 | <birthdate>                 |
      | dontProcess               | <dontProcess>               |
      | dontMarket                | <dontMarket>                |
      | exportIndividualsData     | <exportIndividualsData>     |
      | okToStorePiiDataElsewhere | <okToStorePiiDataElsewhere> |
      | blockGeolocationTracking  | <blockGeolocationTracking>  |
      | dontProfile               | <dontProfile>               |
      | dontTrack                 | <dontTrack>                 |
      | forgetThisIndividual      | <forgetThisIndividual>      |
      | individualsAge            | <individualsAge>            |
    Then The result message should contain the was created text
    And The Individual record header's name title should match the {<salutation> <firstname> <lastname>} text
    And I click on the Individual Details tab
    And The details from the created object should match the given parameters
      | name                      | <name>                      |
      | birthdate                 | <birthdate>                 |
      | dontProcess               | <dontProcess>               |
      | dontMarket                | <dontMarket>                |
      | exportIndividualsData     | <exportIndividualsData>     |
      | okToStorePiiDataElsewhere | <okToStorePiiDataElsewhere> |
      | blockGeolocationTracking  | <blockGeolocationTracking>  |
      | dontProfile               | <dontProfile>               |
      | dontTrack                 | <dontTrack>                 |
      | forgetThisIndividual      | <forgetThisIndividual>      |
      | individualsAge            | <individualsAge>            |
    Examples:
      | salutation | lastname | firstname | name          | birthdate  | dontProcess | dontMarket | exportIndividualsData | okToStorePiiDataElsewhere | blockGeolocationTracking | dontProfile | dontTrack | forgetThisIndividual | individualsAge |
      | Mr.        | Paul     | Jake      | Mr. Jake Paul | 01/01/2000 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |

  @CreateIndividual @RegressionTest
    Scenario Outline: Create a Salesforce Individual object with required parameters
    Given I navigate to the new Individual page
    When I create a new Individual record with required parameters
      | lastname | <lastname> |
    Then The result message should contain the was created text
    And The Individual record header's name title should match the {<salutation> <firstname> <lastname>} text
    And I click on the Individual Details tab
    And The details from the created object should match the given parameters
      | name | <name> |
    Examples:
      | lastname | name |
      | Jake     | Jake |

    @CreateIndividual @Internationalization @Spanish
      Scenario Outline: Create a Salesforce Individual object with required parameters and language in spanish
      Given I set the language settings to Spanish
      And I navigate to the new Individual page
      When I create a new Individual record with the following parameters
        | salutation                | <salutation>                |
        | lastname                  | <lastname>                  |
        | firstname                 | <firstname>                 |
        | birthdate                 | <birthdate>                 |
        | dontProcess               | <dontProcess>               |
        | dontMarket                | <dontMarket>                |
        | exportIndividualsData     | <exportIndividualsData>     |
        | okToStorePiiDataElsewhere | <okToStorePiiDataElsewhere> |
        | blockGeolocationTracking  | <blockGeolocationTracking>  |
        | dontProfile               | <dontProfile>               |
        | dontTrack                 | <dontTrack>                 |
        | forgetThisIndividual      | <forgetThisIndividual>      |
        | individualsAge            | <individualsAge>            |
      Then The result message should contain the was created text
      And The Individual record header's name title should match the {<salutation> <firstname> <lastname>} text
      And I click on the Individual Details tab
      And The details from the created object should match the given parameters
        | name                      | <name>                      |
        | birthdate                 | <birthdate>                 |
        | dontProcess               | <dontProcess>               |
        | dontMarket                | <dontMarket>                |
        | exportIndividualsData     | <exportIndividualsData>     |
        | okToStorePiiDataElsewhere | <okToStorePiiDataElsewhere> |
        | blockGeolocationTracking  | <blockGeolocationTracking>  |
        | dontProfile               | <dontProfile>               |
        | dontTrack                 | <dontTrack>                 |
        | forgetThisIndividual      | <forgetThisIndividual>      |
        | individualsAge            | <individualsAge>            |
      Examples:
        | salutation | lastname | firstname | name          | birthdate  | dontProcess | dontMarket | exportIndividualsData | okToStorePiiDataElsewhere | blockGeolocationTracking | dontProfile | dontTrack | forgetThisIndividual | individualsAge |
        | Mr.        | Paul     | Jake      | Mr. Jake Paul | 01/01/2000 | true        | true       | true                  | true                      | true                     | true        | true      | true                 | 13 or Older    |