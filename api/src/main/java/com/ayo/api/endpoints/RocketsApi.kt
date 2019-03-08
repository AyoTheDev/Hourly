package com.ayo.api.endpoints

import com.ayo.api.model.RocketApi
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.http.GET

interface RocketsApi {

    @GET("rockets")
    fun getRocketsAsync(): Deferred<Response<List<RocketApi>>>

}