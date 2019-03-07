package com.ayo.spacex.di.component

import android.app.Application
import com.ayo.data.di.NetworkModule
import com.ayo.spacex.App
import com.ayo.data.di.LocalModule
import com.ayo.spacex.di.module.RepositoryModule
import com.ayo.spacex.di.module.UseCaseModule
import com.ayo.spacex.di.builder.RocketsActivityBuilder
import com.ayo.spacex.di.module.ViewModelModule
import com.ayo.spacex.di.module.ApplicationModule
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
    RocketsActivityBuilder::class
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
