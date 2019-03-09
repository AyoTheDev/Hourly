package com.ayo.hourly.di.module

import com.ayo.api.services.RocketsService
import com.ayo.api.services.UserService
import com.ayo.data.db.dao.RocketsDao
import com.ayo.data.db.dao.UserDao
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
    fun provideUserRepository(remote: UserService, local: UserDao): Repository<UserDomain> {
        return UserRepository(remote, local)
    }

}