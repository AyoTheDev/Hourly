package com.ayo.hourly.di.component

import android.app.Application
import com.ayo.api.di.NetworkModule
import com.ayo.data.di.LocalDatabaseModule
import com.ayo.data.di.RemoteDatabaseModule
import com.ayo.domain.di.UseCaseModule
import com.ayo.hourly.App
import com.ayo.hourly.di.builder.RocketsActivityBuilder
import com.ayo.hourly.di.module.ApplicationModule
import com.ayo.hourly.di.module.RepositoryModule
import com.ayo.hourly.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        LocalDatabaseModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        RemoteDatabaseModule::class,
        ViewModelModule::class,
        RocketsActivityBuilder::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun localDatabaseModule(localDatabaseModule: LocalDatabaseModule): Builder
        fun remoteDatabaseModule(remoteDatabaseModule: RemoteDatabaseModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun useCaseModule(useCaseModule: UseCaseModule): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(newsSyncApplication: App)
}
