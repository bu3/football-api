package com.football.data.team

import com.football.data.client.FootballDataClient
import com.football.data.client.PlayerShortlist
import com.football.data.client.TeamShortlist
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

    def "should load teams for a season"() {
        given:
        def seasonId = 1L
        def convertedTeams = [new Team(id: 1L), new Team(id: 2L)]
        def teams = [new com.football.data.client.Team(id: 1), new com.football.data.client.Team(id: 2)]
        def teamShortList = new TeamShortlist(count: 2, teams: teams)
        TeamService teamService = new TeamService(footballDataClient: Mock(FootballDataClient), converter: Mock(TeamConverter))

        when:
        def results = teamService.getTeams(seasonId)

        then:
        1 * teamService.footballDataClient.getTeamsForSeason(seasonId) >> {
            teamShortList
        }
        1 * teamService.converter.convert(teams) >> { args ->
            assert args[0][0].id == 1L
            assert args[0][1].id == 2L

            convertedTeams
        }

        results == convertedTeams
    }
}
