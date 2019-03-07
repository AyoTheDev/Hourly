package com.ayo.data.remote.interceptors

import com.ayo.data.remote.exceptions.NetworkException
import com.ayo.data.remote.exceptions.ServerException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val response = chain.proceed(chain.request().newBuilder().build())

        when (response.code()) {
            in 401..499,
            400 -> {
                throw NetworkException(response.code(), response.message())
            }
            in 500..599 -> {
                throw ServerException(response.code(), response.message())
            }
        }

        return response
    }
}