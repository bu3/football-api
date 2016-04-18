package com.football.data.team

import com.football.data.client.FootballDataClient
import com.football.data.client.PlayerShortlist
import spock.lang.Specification


class TeamServiceSpec extends Specification {

    def "should find team by id"() {
        given:
        def originalTeam = new com.football.data.client.Team(name: 'name')
        def shortlist = new PlayerShortlist()
        def team = new Team(players: [new Player(name: 'foo')])
        TeamService teamService = new TeamService(footballDataClient: Mock(FootballDataClient), converter: Mock(TeamConverter))

        when:
        def result = teamService.findTeamById(1)

        then:
        1 * teamService.footballDataClient.getTeam(1) >> {
            originalTeam
        }

        1 * teamService.footballDataClient.getShortList(1) >> {
            shortlist
        }

        1 * teamService.converter.convert(originalTeam, shortlist) >> {
            team
        }

        result == team
    }
}
