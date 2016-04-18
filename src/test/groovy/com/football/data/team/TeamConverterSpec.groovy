package com.football.data.team

import com.football.data.client.PlayerShortlist
import spock.lang.Specification

import java.time.LocalDate


class TeamConverterSpec extends Specification {


    def "Should convert Team"() {
        given:
        TeamConverter teamConverter = new TeamConverter()

        when:
        def team = teamConverter.convert(
                new com.football.data.client.Team(
                        name: 'A.S. Roma',
                        code: 'ROM',
                        shortName: 'Rom',
                        squadMarketValue: '100 €',
                        crestUrl: 'logo.url'),
                new PlayerShortlist(
                        count: 1, players: [
                        new com.football.data.client.Player(
                                "name": "foo",
                                "position": "Centre Back",
                                "jerseyNumber": 87,
                                "dateOfBirth": "1987-02-11",
                                "nationality": "Bosnia-Herzegovina",
                                "contractUntil": "2016-06-30",
                                "marketValue": "4,000,000 €")]))

        then:
        team.name == 'A.S. Roma'
        team.code == 'ROM'
        team.shortName == 'Rom'
        team.marketValue == '100 €'
        team.logoUrl == 'logo.url'
        team.players.size() == 1
        team.players[0].name == 'foo'
        team.players[0].position == 'Centre Back'
        team.players[0].jerseyNumber == 87
        team.players[0].dateOfBirth == new LocalDate(1987, 2, 11)
        team.players[0].nationality == 'Bosnia-Herzegovina'
        team.players[0].contractUntil == new LocalDate(2016, 6, 30)
        team.players[0].marketValue == '4,000,000 €'
    }

}
