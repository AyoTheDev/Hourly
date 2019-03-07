package com.ayo.data.di

import com.ayo.data.remote.endpoints.RocketsApi
import com.ayo.data.remote.services.RocketsService
import dagger.Module
import dagger.Provides

@Module
class ApiServiceModule {

    @Provides
    fun provideRocketsService(rocketsApi: RocketsApi): RocketsService {
        return RocketsService(rocketsApi)
    }
}