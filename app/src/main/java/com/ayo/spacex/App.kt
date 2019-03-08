package com.ayo.spacex

import com.ayo.api.di.NetworkModule
import com.ayo.spacex.di.module.RepositoryModule
import com.ayo.domain.di.UseCaseModule
import com.ayo.spacex.di.module.ApplicationModule
import com.ayo.spacex.di.component.DaggerApplicationComponent
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
                //.localModule(DatabaseModule())
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .useCaseModule(com.ayo.domain.di.UseCaseModule())
                .build()
    }

}