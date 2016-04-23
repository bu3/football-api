Feature: Football API returns Team Players

  Scenario: Api returns Team players
    Given app has started
    When team players are requested
    Then status code 200 returned
    And team players are
      | property                 | value                                                    |
      | name                     | AS Roma                                                  |
      | code                     | ROM                                                      |
      | shortName                | Rom                                                      |
      | marketValue              | 261,700,000 €                                            |
      | logoUrl                  | http://upload.wikimedia.org/wikipedia/de/3/32/AS_Rom.svg |
      | players[0].name          | Ervin Zukanovic                                          |
      | players[0].position      | Centre Back                                              |
      | players[0].jerseyNumber  | 87                                                       |
      | players[0].dateOfBirth   | 1987-02-11                                               |
      | players[0].nationality   | Bosnia-Herzegovina                                       |
      | players[0].contractUntil | 2016-06-30                                               |
      | players[0].marketValue   | 4,000,000 €                                              |

  Scenario: Api returns Teams for season
    Given app has started
    When teams for season "398" are requested
    Then status code 200 returned
    And teams contain
      | property        | value                                                                  |
      | item[0].name        | Manchester United FC                                                   |
      | item[0].code        | MUFC                                                                   |
      | item[0].shortName   | ManU                                                                   |
      | item[0].marketValue | 394,550,000 €                                                          |
      | item[0].logoUrl     | http://upload.wikimedia.org/wikipedia/de/d/da/Manchester_United_FC.svg |