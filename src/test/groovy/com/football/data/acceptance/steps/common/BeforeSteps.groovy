package com.football.data.acceptance.steps.common

import com.football.data.acceptance.common.BaseApiClient
import cucumber.api.groovy.Hooks

this.metaClass.mixin(Hooks)

Before {
  BaseApiClient.givenApiClient().expect().statusCode(200).delete('/health')
}