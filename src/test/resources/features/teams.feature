Feature: Footbal API returns Team Players

  Scenario: Api returns Team players
    Given app has started
    When team players are requested
    Then status code 200 returned
    And team players are
      | property                 | value              |
      | players[0].name          | Ervin Zukanovic    |
      | players[0].position      | Centre Back        |
#      | players[0].jerseyNumber  | 87                 |
      | players[0].dateOfBirth   | 1987-02-11         |
      | players[0].nationality   | Bosnia-Herzegovina |
      | players[0].contractUntil | 2016-06-30         |
      | players[0].marketValue   | 4,000,000 €        |
