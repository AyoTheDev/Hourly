package com.ayo.api.services

import com.ayo.api.handler.ResponseHandler
import com.ayo.api.model.Rocket
import com.ayo.api.endpoints.RocketsApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class RocketsService @Inject constructor(private var api: RocketsApi) {

    @ExperimentalCoroutinesApi
    suspend fun getRockets() : List<Rocket>? {
        val responseHandler = ResponseHandler(api.getRocketsAsync())
        responseHandler.run()
        return responseHandler.response()
    }


}