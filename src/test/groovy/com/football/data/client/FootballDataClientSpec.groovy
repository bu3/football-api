package com.football.data.client

import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.http.HttpMethod.GET

class FootballDataClientSpec extends Specification {

    def 'should load seasons'() {
        given:
        def restTemplate = Mock(RestTemplate)
        FootballDataClient footballDataClient = new FootballDataClient(restTemplate: restTemplate, apiKey: 'apiKey', url: 'service-url')

        when:
        def seasons = footballDataClient.getSeasons('2015')

        then:
        1 * restTemplate.exchange(_ as String, GET, _ as HttpEntity, List, '2015') >> { args ->
            assert args[0] == 'service-url/soccerseasons?season={season}'

            HttpEntity httpEntity = args[2]
            assert httpEntity.headers['X-Auth-Token'][0] == footballDataClient.apiKey

            ResponseEntity.ok(new Season(id: 234))
        }

        seasons != null
        seasons.size() == 1
        seasons[0].id == '234'
    }

    def 'should load teams'() {
        given:
        def restTemplate = Mock(RestTemplate)
        def seasonId = 1
        TeamShortlist teamData = new TeamShortlist( count: 2, teams: [
                new Team(id:1,name: 'name', code: 'code', shortName: 'shortName', squadMarketValue: '1 €', crestUrl: 'logo.url'),
                new Team(id:2,name: 'name2', code: 'code2', shortName: 'shortName2', squadMarketValue: '2 €', crestUrl: 'logo2.url')
        ])
        FootballDataClient footballDataClient = new FootballDataClient(restTemplate: restTemplate, apiKey: 'apiKey', url: 'service-url')

        when:
        TeamShortlist teamShortlist = footballDataClient.getTeamsForSeason(seasonId)

        then:
        1 * restTemplate.exchange(_ as String, GET, _ as HttpEntity, TeamShortlist) >> { args ->
            assert args[0] == "service-url/soccerseasons/${seasonId}/teams"

            HttpEntity httpEntity = args[2]
            assert httpEntity.headers['X-Auth-Token'][0] == footballDataClient.apiKey

            ResponseEntity.ok(teamData)
        }

        teamShortlist == teamData
    }

    def 'should load team'() {
        given:
        def restTemplate = Mock(RestTemplate)
        def teamData = new Team(id:1 , name: 'name', code: 'code', shortName: 'shortName', squadMarketValue: '1 €', crestUrl: 'logo.url')
        FootballDataClient footballDataClient = new FootballDataClient(restTemplate: restTemplate, apiKey: 'apiKey', url: 'service-url')

        when:
        def team = footballDataClient.getTeam(1)

        then:
        1 * restTemplate.exchange(_ as String, GET, _ as HttpEntity, Team, _ as Integer) >> { args ->
            assert args[0] == 'service-url/teams/{teamId}'
            assert args[4][0] == 1

            HttpEntity httpEntity = args[2]
            assert httpEntity.headers['X-Auth-Token'][0] == footballDataClient.apiKey

            ResponseEntity.ok(teamData)
        }

        team == teamData
    }

    def 'should load team players'() {
        given:
        def restTemplate = Mock(RestTemplate)
        FootballDataClient footballDataClient = new FootballDataClient(restTemplate: restTemplate, apiKey: 'apiKey', url: 'service-url')

        when:
        def team = footballDataClient.getShortList(1)

        then:
        1 * restTemplate.exchange(_ as String, GET, _ as HttpEntity, PlayerShortlist, _ as Integer) >> { args ->
            assert args[0] == 'service-url/teams/{teamId}/players'
            assert args[4][0] == 1

            HttpEntity httpEntity = args[2]
            assert httpEntity.headers['X-Auth-Token'][0] == footballDataClient.apiKey

            ResponseEntity.ok(new PlayerShortlist(players: [new Player(name: 'foo')]))
        }

        team != null
        team.players.size() == 1
        team.players[0].name == 'foo'
    }
}
