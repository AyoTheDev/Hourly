package com.ayo.data.di

import com.ayo.data.remote.endpoints.RocketsApi
import com.ayo.data.remote.interceptors.NetworkResponseInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL: String = "https://api.spacexdata.com/v2/"
    }

    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .build()

    }

    /**
     * To improve: should add interceptor for no connectivity
     */
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
                .Builder()
                .addInterceptor(NetworkResponseInterceptor())
                .build()
    }

    @Singleton
    @Provides
    fun provideRocketsApi(retrofit: Retrofit): RocketsApi = retrofit.create(RocketsApi::class.java)
}