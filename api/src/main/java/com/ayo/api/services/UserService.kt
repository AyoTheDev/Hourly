package com.ayo.api.services

import android.util.Log
import com.ayo.api.endpoints.Api
import com.ayo.api.handler.ResponseHandler
import com.ayo.api.model.UserApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class UserService @Inject constructor(private var api: Api.User) {

    @ExperimentalCoroutinesApi
    suspend fun getUser(id: Long): UserApi? {
        val responseHandler = ResponseHandler(api.getUserAsync(id.toString()))
        responseHandler.run()
        return responseHandler.response()
    }

    @ExperimentalCoroutinesApi
    suspend fun addUser(user: UserApi) {
        val responseHandler = ResponseHandler(api.addUserAsync(user.id.toString(), user))
        responseHandler.run()
        val response = responseHandler.response()
        println("test")
    }


}