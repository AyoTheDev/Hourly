package com.ayo.hourly.di.module

import com.ayo.api.services.RocketsService
import com.ayo.data.db.RocketsDao
import com.ayo.data.repository.RocketsRepository
import com.ayo.domain.model.RocketDomain
import com.ayo.domain.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRocketsRepository(remote: RocketsService, local: RocketsDao): Repository<RocketDomain> {
        return RocketsRepository(remote, local)
    }

}