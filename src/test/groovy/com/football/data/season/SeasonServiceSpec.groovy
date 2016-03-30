package com.football.data.season

import com.football.data.client.FootballDataClient
import spock.lang.Specification

class SeasonServiceSpec extends Specification {

    def 'should return a list of seasons'(){

        given:
        SeasonService seasonService = new SeasonService(footballDataClient: Mock(FootballDataClient))

        when:
        def seasons = seasonService.getSeason('2015')

        then:
        1 * seasonService.footballDataClient.getSeasons('2015') >> {
            [new com.football.data.client.Season()]
        }
        seasons.size() == 1
    }

}
