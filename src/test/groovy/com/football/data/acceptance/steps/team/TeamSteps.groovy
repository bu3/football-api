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
    def response = givenApiClient().contentType(JSON).get('/teams/100')
    StoryContext.putInContext(RESPONSE, response)
}

Then(~'^team players are$') { DataTable teamPlayers ->
    checkValues(teamPlayers)
}

When(~'^teams for season "([^"]*)" are requested$') { int seasonId->
    def response = givenApiClient().contentType(JSON).get("/teams?seasonId=398")
    StoryContext.putInContext(RESPONSE, response)
}

Then(~'^teams contain$') { DataTable teamsData ->
    def response = StoryContext.getFromContext(RESPONSE).as(List)
    teamsData.asMaps(String, String).each { row ->
        def result = Eval.me('item', response, "${row.property}").toString()
        def fieldValue = row.value ?: null

        assertThat("item.${row.field}", result, CoreMatchers.is(fieldValue))
    }
}

private void checkValues(DataTable dataTable) {
    def response = StoryContext.getFromContext(RESPONSE).as(Map)

    dataTable.asMaps(String, String).each { row ->
        def result = Eval.me('item', response, "item.${row.property}").toString()
        def fieldValue = row.value ?: null

        assertThat("item.${row.field}", result, CoreMatchers.is(fieldValue))
    }
}
