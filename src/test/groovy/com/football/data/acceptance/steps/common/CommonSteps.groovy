package com.football.data.acceptance.steps.common

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

import static StoryContext.getFromContext
import static com.football.data.acceptance.common.BaseApiClient.givenApiClient
import static com.football.data.acceptance.steps.common.StoryContext.Fields.RESPONSE

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Given(~'^app has started$') { ->
    givenApiClient().expect().statusCode(200).get('/health')
}

Then(~'^status code (\\d+) returned$') { int expectedStatusCode ->
    assert getFromContext(RESPONSE).statusCode == expectedStatusCode
}
