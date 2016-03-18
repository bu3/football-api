package com.football.data.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

import static org.springframework.http.HttpMethod.GET

@Component
class FootballDataClient {

    @Autowired
    RestTemplate restTemplate

    @Value('${footballData.url}')
    String url

    @Value('${footballData.apiKey}')
    String apiKey

    Team getTeam(int teamId){
        def headers = new HttpHeaders()
        headers.add('X-Auth-Token', apiKey)
        HttpEntity entity = new HttpEntity(headers)
        ResponseEntity<Team> responseEntity = restTemplate.exchange("${url}/teams/{teamId}/players", GET, entity, Team.class, teamId)

        responseEntity.body
    }
}