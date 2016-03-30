package com.football.data.acceptance.steps.team

import com.football.data.acceptance.steps.common.StoryContext
import cucumber.api.DataTable
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import org.hamcrest.CoreMatchers

import static com.football.data.acceptance.common.BaseApiClient.givenApiClient
import static com.football.data.acceptance.steps.common.StoryContext.Fields.RESPONSE
import static com.jayway.restassured.http.ContentType.JSON
import static org.junit.Assert.assertThat

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

When(~'^team players are requested$') { ->
    def response = givenApiClient().contentType(JSON).get('/team/100')
    StoryContext.putInContext(RESPONSE, response)
}

Then(~'^team players are$') { DataTable teamPlayers ->
    def response = StoryContext.getFromContext(RESPONSE).as(Map)

    teamPlayers.asMaps(String,String).each { row ->
        def result = Eval.me('team', response, "team.${row.property}").toString()
        def fieldValue = row.value ?: null

        assertThat("trip.${row.field}", result, CoreMatchers.is(fieldValue))
    }
}


