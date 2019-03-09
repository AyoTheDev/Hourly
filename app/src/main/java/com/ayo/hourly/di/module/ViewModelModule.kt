package com.ayo.hourly.di.module

import androidx.lifecycle.ViewModelProvider
import com.ayo.hourly.di.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}