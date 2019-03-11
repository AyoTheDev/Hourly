package com.ayo.api.di

import com.ayo.api.endpoints.RocketsApi
import com.ayo.api.interceptors.NetworkResponseInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val ROCKETS_BASE_URL: String = "https://api.spacexdata.com/v2/"
        private const val FIREBASE_URL: String = "https://hourly-330ab.firebaseio.com/"
    }

    @Provides
    @Named("spacex")
    fun provideRocketsRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ROCKETS_BASE_URL)
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
    fun provideRocketsApi(@Named("spacex") retrofit: Retrofit): RocketsApi =
        retrofit.create(RocketsApi::class.java)

}