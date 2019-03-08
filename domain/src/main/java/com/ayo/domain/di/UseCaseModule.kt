package com.ayo.domain.di

import com.ayo.domain.model.RocketDomain
import com.ayo.domain.repository.Repository
import com.ayo.domain.usecase.RocketsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideRocketsUseCase(rocketRepository: Repository<RocketDomain>): RocketsUseCase {
        return RocketsUseCase(rocketRepository)
    }


}