package com.ayo.hourly.di.module

import androidx.lifecycle.ViewModel
import com.ayo.hourly.ui.rockets.RocketsViewModel
import com.ayo.hourly.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface RocketsModule {

    @Binds
    @IntoMap
    @ViewModelKey(RocketsViewModel::class)
    fun bindRocketsViewModel(mainViewModel: RocketsViewModel): ViewModel

}