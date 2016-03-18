package com.football.data.client

import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.http.HttpMethod.GET

class FootballDataClientSpec extends Specification {

    def 'should get team players'() {
        given:
        def restTemplate = Mock(RestTemplate)
        FootballDataClient footballDataClient = new FootballDataClient(restTemplate: restTemplate, apiKey: 'apiKey', url: 'service-url')

        when:
        def team = footballDataClient.getTeam(1)

        then:
        1 * restTemplate.exchange(_ as String, GET, _ as HttpEntity, Team, _ as Integer) >> { args ->
            assert args[0] == 'service-url/teams/{teamId}/players'
            assert args[4][0] == 1

            HttpEntity httpEntity = args[2]
            assert httpEntity.headers['X-Auth-Token'][0] == footballDataClient.apiKey

            ResponseEntity.ok(new Team(players: [new Player(name: 'foo')]))
        }

        team != null
        team.players.size() == 1
        team.players[0].name == 'foo'
    }

}
