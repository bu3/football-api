package com.football.data.season

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class SeasonController {

    @Autowired
    private SeasonService seasonService

    @RequestMapping(value = '/seasons', method = GET)
    @ResponseBody
    Season[] getSeasons(@RequestParam String season){
        seasonService.getSeason(season)
    }

}
