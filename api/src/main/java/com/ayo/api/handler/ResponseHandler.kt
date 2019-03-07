package com.ayo.api.handler

import kotlinx.coroutines.*
import retrofit2.Response

class ResponseHandler<out T> constructor(private var job: Deferred<Response<T>>) {

    private lateinit var response: Response<T>
    private var hasRun = false

    @ExperimentalCoroutinesApi
    suspend fun run() {
        hasRun = true
        response = job.await()

        val exception = job.getCompletionExceptionOrNull()

        if (exception != null) {
            throw exception
        }
    }

    fun response(): T? {
        if (hasRun)
            return response.body()
        else
            throw RuntimeException("The job must be run before trying to access the result")
    }
}