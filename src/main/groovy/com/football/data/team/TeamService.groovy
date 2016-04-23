package com.football.data.team

import com.football.data.client.FootballDataClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TeamService {

    @Autowired
    FootballDataClient footballDataClient

    @Autowired
    TeamConverter converter

    Team findTeamById(int teamId) {
        def team = footballDataClient.getTeam(teamId)
        def list = footballDataClient.getShortList(teamId)
        converter.convert(team, list)
    }

    Team[] getTeams(Long seasonId){
        def teamShortlist = footballDataClient.getTeamsForSeason(seasonId)

        converter.convert(teamShortlist.teams)
    }
}