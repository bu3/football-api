package com.football.data.team

import com.fasterxml.jackson.annotation.JsonFormat
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

@ToString
@EqualsAndHashCode
class Team {

    String name
    String code
    String shortName
    String marketValue
    String logoUrl

    List<Player> players
}

@ToString
@EqualsAndHashCode
class Player{
    String name
    String position
    int jerseyNumber
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate dateOfBirth
    String nationality
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate contractUntil
    String marketValue
}
