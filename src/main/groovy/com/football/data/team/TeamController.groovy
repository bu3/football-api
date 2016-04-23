package com.football.data.team

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import static org.springframework.http.HttpStatus.OK
import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class TeamController {

    @Autowired
    TeamService teamService

    @RequestMapping(value = 'teams', method = GET)
    @ResponseStatus(OK)
    Team[] getTeams(@RequestParam(required = true) int seasonId) {
        teamService.getTeams(seasonId)
    }

    @RequestMapping(value = 'teams/{teamId}', method = GET)
    ResponseEntity<Team> getTeam(@PathVariable int teamId) {
        def team = teamService.findTeamById(teamId)
        team ? ResponseEntity.ok(team) : new ResponseEntity<>(HttpStatus.NOT_FOUND)
    }
}