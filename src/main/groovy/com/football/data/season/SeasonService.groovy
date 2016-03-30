package com.football.data.season

import com.football.data.client.FootballDataClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SeasonService {

    @Autowired
    private FootballDataClient footballDataClient

    Season[] getSeason(String season){
        def seasons = []
        footballDataClient.getSeasons(season).each { s ->
            seasons << new Season(id: s.id, year: s.year, caption: s.caption, league: s.league, numberOfGames: s.numberOfGames, numberOfTeams: s.numberOfTeams)
        }

        seasons
    }

}
