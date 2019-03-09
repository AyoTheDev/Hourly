package com.ayo.hourly.di.component

import android.app.Application
import com.ayo.api.di.NetworkModule
import com.ayo.hourly.App
import com.ayo.data.di.DatabaseModule
import com.ayo.domain.di.UseCaseModule
import com.ayo.hourly.di.module.RepositoryModule
import com.ayo.hourly.di.builder.RocketsActivityBuilder
import com.ayo.hourly.di.module.ViewModelModule
import com.ayo.hourly.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    RocketsActivityBuilder::class
])
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun databaseModule(databaseModule: DatabaseModule): Builder
        fun networkModule(networkModule: com.ayo.api.di.NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun useCaseModule(useCaseModule: UseCaseModule): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(newsSyncApplication: App)
}
