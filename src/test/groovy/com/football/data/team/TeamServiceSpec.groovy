package com.football.data.team

import com.football.data.client.FootballDataClient
import spock.lang.Specification


class TeamServiceSpec extends Specification {

    def "should find team by id"() {
        given:
        def originalTeam = new com.football.data.client.Team()
        TeamService teamService = new TeamService(footballDataClient: Mock(FootballDataClient), converter: Mock(TeamConverter))

        when:
        def team = teamService.findTeamById(1)

        then:
        1 * teamService.footballDataClient.getTeam(1) >> {
            originalTeam
        }

        1 * teamService.converter.convert(originalTeam) >> {
            new Team(players: [new Player(name: 'foo')])
        }

        team != null
        team.players == [new Player(name: 'foo')]
    }
}
