package com.football.data.client

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Team {
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


