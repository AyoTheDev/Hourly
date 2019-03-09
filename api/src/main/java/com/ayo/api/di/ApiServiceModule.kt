package com.ayo.api.di

import com.ayo.api.endpoints.Api
import com.ayo.api.endpoints.RocketsApi
import com.ayo.api.services.ContractService
import com.ayo.api.services.RocketsService
import com.ayo.api.services.UserService
import dagger.Module
import dagger.Provides

@Module
class ApiServiceModule {

    @Provides
    fun provideRocketsService(rocketsApi: RocketsApi): RocketsService {
        return RocketsService(rocketsApi)
    }

    @Provides
    fun provideUserService(userApi: Api.User): UserService {
        return UserService(userApi)
    }

    @Provides
    fun provideContractService(contractApi: Api.Contract): ContractService {
        return ContractService(contractApi)
    }
}