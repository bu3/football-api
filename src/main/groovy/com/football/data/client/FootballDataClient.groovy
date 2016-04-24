package com.football.data.client

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

import static org.springframework.http.HttpMethod.GET

@Slf4j
@Component
class FootballDataClient {

    @Autowired
    RestTemplate restTemplate

    @Value('${footballData.url}')
    String url

    @Value('${footballData.apiKey}')
    String apiKey

    Season[] getSeasons(String season) {
        def headers = new HttpHeaders()
        headers.add('X-Auth-Token', apiKey)
        ResponseEntity<List<Season>> responseEntity = restTemplate.exchange("${url}/soccerseasons?season={season}", GET, new HttpEntity(headers), List.class, season)

        responseEntity.body
    }

    Team getTeam(int teamId) {
        def headers = new HttpHeaders()
        headers.add('X-Auth-Token', apiKey)
        ResponseEntity<Team> responseEntity = restTemplate.exchange("${url}/teams/{teamId}", GET, new HttpEntity(headers), Team.class, teamId)

        responseEntity.body
    }

    PlayerShortlist getShortList(int teamId) {
        def headers = new HttpHeaders()
        headers.add('X-Auth-Token', apiKey)
        ResponseEntity<PlayerShortlist> responseEntity = restTemplate.exchange("${url}/teams/{teamId}/players", GET, new HttpEntity(headers), PlayerShortlist.class, teamId)

        responseEntity.body
    }

    TeamShortlist getTeamsForSeason(Long seasonId) {
        def headers = new HttpHeaders()
        headers.add('X-Auth-Token', apiKey)
        headers.add('X-Response-Control', 'minified')
        ResponseEntity<TeamShortlist> responseEntity = restTemplate.exchange("${url}/soccerseasons/${seasonId}/teams", GET, new HttpEntity(headers), TeamShortlist)

        responseEntity.body
    }
}