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
                        id: 1,
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
        team.id == 1L
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

    def "Should convert a list of Team"() {
        given:
        com.football.data.client.Team[] teams = [
                new com.football.data.client.Team(id: 1, code: 'code', name: 'name', shortName: 'shortName', crestUrl: 'logoUrl'),
                new com.football.data.client.Team(id: 2, code: 'code2', name: 'name2', shortName: 'shortName2', crestUrl: 'logoUrl2')
        ]
        TeamConverter teamConverter = new TeamConverter()

        when:
        def result = teamConverter.convert(teams)

        then:
        result.size() == 2
        result[0].id == 1L
        result[0].code == 'code'
        result[0].name == 'name'
        result[0].shortName == 'shortName'
        result[0].logoUrl == 'logoUrl'
        result[1].id == 2L
        result[1].code == 'code2'
        result[1].name == 'name2'
        result[1].shortName == 'shortName2'
        result[1].logoUrl == 'logoUrl2'
    }
}
