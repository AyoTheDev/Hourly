package com.ayo.hourly.di.module

import com.ayo.api.services.RocketsService
import com.ayo.data.local.dao.RocketsDao
import com.ayo.data.local.dao.UserDao
import com.ayo.data.network.UserNetworkRepo
import com.ayo.data.repository.RocketsRepository
import com.ayo.data.repository.UserRepository
import com.ayo.domain.model.RocketDomain
import com.ayo.domain.model.UserDomain
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

    @Singleton
    @Provides
    fun provideUserRepository(remote: UserNetworkRepo, local: UserDao): Repository<UserDomain> {
        return UserRepository(remote, local)
    }

}