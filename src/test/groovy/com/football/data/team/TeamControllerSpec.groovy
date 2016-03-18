package com.football.data.team

import org.hamcrest.CoreMatchers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class TeamControllerSpec extends Specification {

    def 'should return team players list'() {
        given:
        TeamController teamController = new TeamController(teamService: Mock(TeamService))
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(teamController).build()

        when:
        def response = mockMvc.perform(get("/team/100").accept(APPLICATION_JSON))

        then:
        1 * teamController.teamService.findTeamById(100) >> {
            new Team(players: [])
        }
        response.andExpect(status().isOk()).andExpect(jsonPath('$.players', CoreMatchers.is(CoreMatchers.not(null))))
    }

    def 'should return 404 if team does not exist'() {
        given:
        TeamController teamController = new TeamController(teamService: Mock(TeamService))
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(teamController).build()

        when:
        def response = mockMvc.perform(get("/team/1").accept(APPLICATION_JSON))

        then:
        1 * teamController.teamService.findTeamById(1) >> {
            null
        }
        response.andExpect(status().isNotFound())
    }
}
