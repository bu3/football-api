package com.football.data.season

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

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
