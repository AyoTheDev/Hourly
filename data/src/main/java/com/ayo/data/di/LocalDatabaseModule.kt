package com.ayo.data.di

import android.content.Context
import androidx.room.Room
import com.ayo.data.local.AppDatabase
import com.ayo.data.local.dao.*
import dagger.Module
import dagger.Provides

@Module
class LocalDatabaseModule {

    @Provides
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "hourly.db").build()

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    fun provideShiftDao(database: AppDatabase): ShiftDao = database.shiftDao()

    @Provides
    fun provideFenceDao(database: AppDatabase): FenceDao = database.fenceDao()

    @Provides
    fun provideEmployerDao(database: AppDatabase): EmployerDao = database.employerDao()

    @Provides
    fun provideLocationDao(database: AppDatabase): LocationDao = database.locationDao()

    @Provides
    fun provideContractDao(database: AppDatabase): ContractDao = database.contractDao()

    @Provides
    fun provideRocketsDao(database: AppDatabase): RocketsDao = database.rocketsDao()

}
