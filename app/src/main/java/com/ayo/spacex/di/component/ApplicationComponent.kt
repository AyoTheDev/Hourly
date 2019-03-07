package com.ayo.spacex.di.component

import android.app.Application
import com.ayo.data.di.NetworkModule
import com.ayo.spacex.App
import com.ayo.spacex.di.LocalModule
import com.ayo.spacex.di.RepositoryModule
import com.ayo.spacex.di.UseCaseModule
import com.ayo.spacex.di.builder.RocketListActivityBuilder
import com.ayo.spacex.di.module.ViewModelModule
import com.ayo.spacex.di.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    LocalModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    RocketListActivityBuilder::class
])
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun localModule(localModule: LocalModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun useCaseModule(useCaseModule: UseCaseModule): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(newsSyncApplication: App)
}
