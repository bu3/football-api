package com.football.data.team

import com.football.data.client.PlayerShortlist
import org.springframework.stereotype.Component

import java.time.LocalDate

@Component
class TeamConverter {

    Team convert(com.football.data.client.Team team, PlayerShortlist shortlist) {
        def playersShortlist = parsePlayers(shortlist.players)

        new Team(
                id: team.id,
                name: team.name,
                code: team.code,
                shortName: team.shortName,
                marketValue: team.squadMarketValue,
                logoUrl: team.crestUrl,
                players: playersShortlist)
    }

    Team[] convert(com.football.data.client.Team[] teams) {
        def convertedTeams = []
        teams.each({ team ->
            def team1 = new Team(
                    id: team.id,
                    name: team.name,
                    code: team.code,
                    shortName: team.shortName,
                    marketValue: team.squadMarketValue,
                    logoUrl: team.crestUrl)

            convertedTeams << team1
        });

        convertedTeams
    }

    private static List<Player> parsePlayers(List<com.football.data.client.Player> players) {
        List<Player> playerList = []
        players.each { com.football.data.client.Player p ->
            playerList.add(parsePlayer(p))
        }

        playerList
    }

    private static Player parsePlayer(com.football.data.client.Player player) {
        new Player(
                name: player.name,
                position: player.position,
                jerseyNumber: player.jerseyNumber,
                dateOfBirth: LocalDate.parse(player.dateOfBirth),
                nationality: player.nationality,
                contractUntil: player.contractUntil ? LocalDate.parse(player.contractUntil) : null,
                marketValue: player.marketValue)
    }
}
