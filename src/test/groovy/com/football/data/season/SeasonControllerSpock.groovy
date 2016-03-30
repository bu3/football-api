package com.football.data.season

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.hamcrest.Matchers.hasSize
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class SeasonControllerSpock extends Specification {

    def 'should return seasons'() {
        given:
        SeasonController seasonController = new SeasonController(seasonService: Mock(SeasonService))
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(seasonController).build()

        when:
        def response = mockMvc.perform(get("/seasons?season=2015").accept(APPLICATION_JSON))

        then:
        1 * seasonController.seasonService.getSeason('2015') >> { [new Season(), new Season()]}
        response.andExpect(status().isOk()).andExpect(jsonPath('$', hasSize(2)))
    }

    def 'should return bad request'() {
        given:
        SeasonController seasonController = new SeasonController()
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(seasonController).build()

        when:
        def response = mockMvc.perform(get("/seasons").accept(APPLICATION_JSON))

        then:
        response.andExpect(status().isBadRequest())
    }

}
