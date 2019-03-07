package com.ayo.api.di

import com.ayo.api.endpoints.RocketsApi
import com.ayo.api.services.RocketsService
import dagger.Module
import dagger.Provides

@Module
class ApiServiceModule {

    @Provides
    fun provideRocketsService(rocketsApi: RocketsApi): RocketsService {
        return RocketsService(rocketsApi)
    }
}