package com.ayo.spacex.di.module

import android.content.Context
import com.ayo.data.db.RocketsDao
import com.ayo.spacex.SharedPrefs
import com.ayo.api.services.RocketsService
import com.ayo.data.repository.RocketsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRocketsRepository(remote: RocketsService, local: RocketsDao): RocketsRepository {
        return RocketsRepository(remote, local)
    }

    @Singleton
    @Provides
    fun provideSharedPrefs(context: Context): SharedPrefs {
        return SharedPrefs(context)
    }
}