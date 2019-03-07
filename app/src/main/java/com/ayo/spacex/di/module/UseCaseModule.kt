package com.ayo.spacex.di.module

import com.ayo.spacex.CoroutineContextProvider
import com.ayo.data.repository.RocketsRepository
import com.ayo.spacex.usecase.RocketsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideCoroutineContext(): CoroutineContextProvider {
        return CoroutineContextProvider()
    }

    @Singleton
    @Provides
    fun provideRocketsUseCase(rocketsRepository: RocketsRepository): RocketsUseCase {
        return RocketsUseCase(rocketsRepository)
    }


}