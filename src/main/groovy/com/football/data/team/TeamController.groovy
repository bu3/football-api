package com.football.data.team

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class TeamController {

    @Autowired
    TeamService teamService

    @RequestMapping(value = 'team/{teamId}', method = RequestMethod.GET)
    ResponseEntity<Team> getTeam(@PathVariable int teamId) {
        def team = teamService.findTeamById(teamId)
        team ? ResponseEntity.ok(team) : new ResponseEntity<>(HttpStatus.NOT_FOUND)
    }
}