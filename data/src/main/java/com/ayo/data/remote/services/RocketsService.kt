package com.ayo.data.remote.services

import com.ayo.data.remote.handler.ResponseHandler
import com.ayo.data.local.model.Rocket
import com.ayo.data.remote.endpoints.RocketsApi
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