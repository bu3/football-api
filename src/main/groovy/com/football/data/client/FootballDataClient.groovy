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

    Team getTeam(int teamId) {
        def headers = new HttpHeaders()
        headers.add('X-Auth-Token', apiKey)
        ResponseEntity<Team> responseEntity = restTemplate.exchange("${url}/teams/{teamId}/players", GET, new HttpEntity(headers), Team.class, teamId)

        responseEntity.body
    }
}