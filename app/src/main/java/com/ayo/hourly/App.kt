package com.ayo.hourly

import com.ayo.api.di.NetworkModule
import com.ayo.data.di.DatabaseModule
import com.ayo.hourly.di.module.RepositoryModule
import com.ayo.hourly.di.module.ApplicationModule
import com.ayo.hourly.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
                .application(this)
                .applicationModule(ApplicationModule(applicationContext))
                .databaseModule(DatabaseModule())
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .useCaseModule(com.ayo.domain.di.UseCaseModule())
                .build()
    }

}