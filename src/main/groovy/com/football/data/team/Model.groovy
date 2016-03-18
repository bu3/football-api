package com.football.data.team

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

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
    LocalDate dateOfBirth
    String nationality
    LocalDate contractUntil
    String marketValue
}
