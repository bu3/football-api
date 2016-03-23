package com.football.data.team

import com.fasterxml.jackson.annotation.JsonFormat
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate
import java.time.Period

@ToString
@EqualsAndHashCode
class Team {
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
