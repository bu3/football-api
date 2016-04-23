package com.football.data.client

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class TeamShortlist {
    int count
    Team[] teams
}

@ToString
@EqualsAndHashCode
class Team {
    Long id
    String name
    String code
    String shortName
    String squadMarketValue
    String crestUrl
}

@ToString
@EqualsAndHashCode
class PlayerShortlist {
    int count
    List<Player> players
}

@ToString
@EqualsAndHashCode
class Player {
    String name
    String position
    int jerseyNumber
    String dateOfBirth
    String nationality
    String contractUntil
    String marketValue
}

@ToString
@EqualsAndHashCode
class Season {

    String id
    String caption
    String league
    String year
    String numberOfTeams
    String numberOfGames
}


