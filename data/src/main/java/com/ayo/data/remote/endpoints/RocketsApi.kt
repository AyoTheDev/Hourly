package com.ayo.data.remote.endpoints

import com.ayo.data.local.model.Rocket
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.http.GET

interface RocketsApi {

    @GET("rockets")
    fun getRocketsAsync(): Deferred<Response<List<Rocket>>>

}