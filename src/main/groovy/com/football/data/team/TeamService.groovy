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

    Team findTeamById(int teamId){
        converter.convert(footballDataClient.getTeam(teamId))
    }

}