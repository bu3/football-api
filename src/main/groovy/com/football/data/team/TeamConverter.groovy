package com.football.data.team

import org.springframework.stereotype.Component

import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class TeamConverter {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    Team convert(com.football.data.client.Team team) {
        new Team(players: parsePlayers(team.players))
    }


    private List<Player> parsePlayers(List<com.football.data.client.Player> players) {
        List<Player> playerList = []
        players.each { com.football.data.client.Player p ->
            playerList.add(parsePlayer(p))
        }

        playerList
    }

    private Player parsePlayer(com.football.data.client.Player player) {

        new Player(
                name: player.name,
                position: player.position,
                jerseyNumber: player.jerseyNumber,
                dateOfBirth: LocalDate.parse(player.dateOfBirth, formatter),
                nationality: player.nationality,
                contractUntil: player.contractUntil ? LocalDate.parse(player.contractUntil, formatter) : null,
                marketValue: player.marketValue)
    }
}
