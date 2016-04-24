package com.football.data.team

import groovy.util.logging.Slf4j
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@Slf4j
@Profile('mock')
@RestController
class MockFootballApiController {

    @RequestMapping(value = '/mock/soccerseasons/{seasonId}/teams', method = GET)
    public String getTeams(@PathVariable String seasonId){
        return "{\"count\":20,\"teams\":[{\"id\":66,\"name\":\"Manchester United FC\",\"shortName\":\"ManU\",\"squadMarketValue\":\"394,550,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/d/da/Manchester_United_FC.svg\"},{\"id\":73,\"name\":\"Tottenham Hotspur FC\",\"shortName\":\"Spurs\",\"squadMarketValue\":\"278,000,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/b/b4/Tottenham_Hotspur.svg\"},{\"id\":1044,\"name\":\"AFC Bournemouth\",\"shortName\":\"Bournemouth\",\"squadMarketValue\":\"88,800,000 €\",\"crestUrl\":\"https://upload.wikimedia.org/wikipedia/de/4/41/Afc_bournemouth.svg\"},{\"id\":58,\"name\":\"Aston Villa FC\",\"shortName\":\"Aston Villa\",\"squadMarketValue\":\"114,750,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/9/9f/Aston_Villa_logo.svg\"},{\"id\":62,\"name\":\"Everton FC\",\"shortName\":\"Everton\",\"squadMarketValue\":\"209,500,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/f/f9/Everton_FC.svg\"},{\"id\":346,\"name\":\"Watford FC\",\"shortName\":\"Watford\",\"squadMarketValue\":\"93,950,000 €\",\"crestUrl\":\"https://upload.wikimedia.org/wikipedia/en/e/e2/Watford.svg\"},{\"id\":338,\"name\":\"Leicester City FC\",\"shortName\":\"Foxes\",\"squadMarketValue\":\"95,500,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/en/6/63/Leicester02.png\"},{\"id\":71,\"name\":\"Sunderland AFC\",\"shortName\":\"Sunderland\",\"squadMarketValue\":\"98,500,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/6/60/AFC_Sunderland.svg\"},{\"id\":68,\"name\":\"Norwich City FC\",\"shortName\":\"Norwich\",\"squadMarketValue\":\"91,000,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/8/8c/Norwich_City.svg\"},{\"id\":354,\"name\":\"Crystal Palace FC\",\"shortName\":\"Crystal\",\"squadMarketValue\":\"121,250,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/b/bf/Crystal_Palace_F.C._logo_%282013%29.png\"},{\"id\":61,\"name\":\"Chelsea FC\",\"shortName\":\"Chelsea\",\"squadMarketValue\":\"523,650,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/5/5c/Chelsea_crest.svg\"},{\"id\":72,\"name\":\"Swansea City FC\",\"shortName\":\"Swans\",\"squadMarketValue\":\"116,100,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/a/ab/Swansea_City_Logo.svg\"},{\"id\":67,\"name\":\"Newcastle United FC\",\"shortName\":\"Newcastle\",\"squadMarketValue\":\"188,250,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/5/56/Newcastle_United_Logo.svg\"},{\"id\":340,\"name\":\"Southampton FC\",\"shortName\":\"Southampton\",\"squadMarketValue\":\"194,750,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/c/c9/FC_Southampton.svg\"},{\"id\":57,\"name\":\"Arsenal FC\",\"shortName\":\"Arsenal\",\"squadMarketValue\":\"393,000,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/en/5/53/Arsenal_FC.svg\"},{\"id\":563,\"name\":\"West Ham United FC\",\"shortName\":\"West Ham\",\"squadMarketValue\":\"176,000,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/e/e0/West_Ham_United_FC.svg\"},{\"id\":70,\"name\":\"Stoke City FC\",\"shortName\":\"Stoke\",\"squadMarketValue\":\"122,250,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/a/a3/Stoke_City.svg\"},{\"id\":64,\"name\":\"Liverpool FC\",\"shortName\":\"Liverpool\",\"squadMarketValue\":\"367,950,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/0/0a/FC_Liverpool.svg\"},{\"id\":74,\"name\":\"West Bromwich Albion FC\",\"shortName\":\"West Bromwich\",\"squadMarketValue\":\"107,000,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/8/8b/West_Bromwich_Albion.svg\"},{\"id\":65,\"name\":\"Manchester City FC\",\"shortName\":\"ManCity\",\"squadMarketValue\":\"510,000,000 €\",\"crestUrl\":\"http://upload.wikimedia.org/wikipedia/de/f/fd/ManCity.svg\"}]}"
    }

    @RequestMapping(value = '/mock/teams/{teamId}', method = GET)
    public String getTeam(@PathVariable String teamId){
        log.debug("Team id: ${teamId}")
        return '{"_links":{"self":{"href":"http://api.football-data.org/v1/teams/100"},"fixtures":{"href":"http://api.football-data.org/v1/teams/100/fixtures"},"players":{"href":"http://api.football-data.org/v1/teams/100/players"}},"name":"AS Roma","code":"ROM","shortName":"Rom","squadMarketValue":"261,700,000 €","crestUrl":"http://upload.wikimedia.org/wikipedia/de/3/32/AS_Rom.svg"}'
    }

    @RequestMapping(value = '/mock/teams/{teamId}/players', method = GET)
    public String getTeamPlayers(@PathVariable String teamId){
        log.debug("PlayerShortlist team id: ${teamId}")
        return '{"_links":{"self":{"href":"http://api.football-data.org/v1/teams/100/players"},"team":{"href":"http://api.football-data.org/v1/teams/100"}},"count":28,"players":[{"name":"Ervin Zukanovic","position":"Centre Back","jerseyNumber":87,"dateOfBirth":"1987-02-11","nationality":"Bosnia-Herzegovina","contractUntil":"2016-06-30","marketValue":"4,000,000 €"},{"name":"Morgan De Sanctis","position":"Keeper","jerseyNumber":26,"dateOfBirth":"1977-03-26","nationality":"Italy","contractUntil":"2016-06-30","marketValue":"500,000 €"},{"name":"Bogdan Lobont","position":"Keeper","jerseyNumber":1,"dateOfBirth":"1978-01-18","nationality":"Romania","contractUntil":"2016-06-30","marketValue":"100,000 €"},{"name":"Konstantinos Manolas","position":"Centre Back","jerseyNumber":44,"dateOfBirth":"1991-06-14","nationality":"Greece","contractUntil":"2019-06-30","marketValue":"20,000,000 €"},{"name":"Leandro Castán","position":"Centre Back","jerseyNumber":5,"dateOfBirth":"1986-11-05","nationality":"Brazil","contractUntil":"2018-06-30","marketValue":"7,000,000 €"},{"name":"Vasilis Torosidis","position":"Right-Back","jerseyNumber":35,"dateOfBirth":"1985-06-10","nationality":"Greece","contractUntil":"2017-06-30","marketValue":"3,500,000 €"},{"name":"Daniele De Rossi","position":"Defensive Midfield","jerseyNumber":16,"dateOfBirth":"1983-07-24","nationality":"Italy","contractUntil":"2017-06-30","marketValue":"7,000,000 €"},{"name":"Miralem Pjanic","position":"Central Midfield","jerseyNumber":15,"dateOfBirth":"1990-04-02","nationality":"Bosnia-Herzegovina","contractUntil":"2018-06-30","marketValue":"35,000,000 €"},{"name":"Radja Nainggolan","position":"Central Midfield","jerseyNumber":4,"dateOfBirth":"1988-05-04","nationality":"Belgium","contractUntil":"2020-06-30","marketValue":"27,000,000 €"},{"name":"Kevin Strootman","position":"Central Midfield","jerseyNumber":6,"dateOfBirth":"1990-02-13","nationality":"Netherlands","contractUntil":"2018-06-30","marketValue":"15,000,000 €"},{"name":"Seydou Keita","position":"Defensive Midfield","jerseyNumber":20,"dateOfBirth":"1980-01-16","nationality":"Mali","contractUntil":"2016-06-30","marketValue":"500,000 €"},{"name":"Salih Ucan","position":"Attacking Midfield","jerseyNumber":48,"dateOfBirth":"1994-01-06","nationality":"Turkey","contractUntil":"2016-06-30","marketValue":"3,000,000 €"},{"name":"Alessandro Florenzi","position":"Right-Back","jerseyNumber":24,"dateOfBirth":"1991-03-11","nationality":"Italy","contractUntil":"2019-06-30","marketValue":"20,000,000 €"},{"name":"Francesco Totti","position":"Centre Forward","jerseyNumber":10,"dateOfBirth":"1976-09-27","nationality":"Italy","contractUntil":"2016-06-30","marketValue":"1,000,000 €"},{"name":"Stephan El Shaarawy","position":"Left Wing","jerseyNumber":22,"dateOfBirth":"1992-10-27","nationality":"Italy","contractUntil":"2016-06-30","marketValue":"14,000,000 €"},{"name":"Emerson","position":"Left-Back","jerseyNumber":33,"dateOfBirth":"1994-08-03","nationality":"Brazil","contractUntil":"2016-06-30","marketValue":"400,000 €"},{"name":"Iago Falqué","position":"Left Wing","jerseyNumber":14,"dateOfBirth":"1990-01-04","nationality":"Spain","contractUntil":"2020-06-30","marketValue":"8,000,000 €"},{"name":"Diego Perotti","position":"Left Wing","jerseyNumber":8,"dateOfBirth":"1988-07-26","nationality":"Argentina","contractUntil":"2020-06-30","marketValue":"9,500,000 €"},{"name":"Antonio Rüdiger","position":"Centre Back","jerseyNumber":2,"dateOfBirth":"1993-03-03","nationality":"Germany","contractUntil":"2016-06-30","marketValue":"9,000,000 €"},{"name":"Wojciech Szczesny","position":"Keeper","jerseyNumber":25,"dateOfBirth":"1990-04-18","nationality":"Poland","contractUntil":"2016-06-30","marketValue":"10,000,000 €"},{"name":"Edin Dzeko","position":"Centre Forward","jerseyNumber":9,"dateOfBirth":"1986-03-17","nationality":"Bosnia-Herzegovina","contractUntil":"2016-06-30","marketValue":"15,000,000 €"},{"name":"Mohamed Salah","position":"Right Wing","jerseyNumber":11,"dateOfBirth":"1992-06-15","nationality":"Egypt","contractUntil":"2019-06-30","marketValue":"20,000,000 €"},{"name":"Lucas Digne","position":"Left-Back","jerseyNumber":3,"dateOfBirth":"1993-07-20","nationality":"France","contractUntil":"2016-06-30","marketValue":"10,000,000 €"},{"name":"Norbert Gyömber","position":"Centre Back","jerseyNumber":23,"dateOfBirth":"1992-07-03","nationality":"Slovakia","contractUntil":"2016-06-30","marketValue":"800,000 €"},{"name":"William Vainqueur","position":"Defensive Midfield","jerseyNumber":21,"dateOfBirth":"1988-11-19","nationality":"France","contractUntil":"2018-06-30","marketValue":"5,000,000 €"},{"name":"Ezequiel Ponce","position":"Centre Forward","jerseyNumber":18,"dateOfBirth":"1997-03-29","nationality":"Argentina","contractUntil":"2020-06-30","marketValue":"4,500,000 €"},{"name":"Gerson","position":"Attacking Midfield","jerseyNumber":null,"dateOfBirth":"1997-05-20","nationality":"Brazil","contractUntil":null,"marketValue":"10,000,000 €"},{"name":"Umar Sadiq","position":"Centre Forward","jerseyNumber":97,"dateOfBirth":"1997-02-02","nationality":"Nigeria","contractUntil":"2016-06-30","marketValue":"900,000 €"}]}'
    }
}