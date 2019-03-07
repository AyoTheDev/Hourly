package com.ayo.spacex.di.module

import androidx.lifecycle.ViewModel
import com.ayo.spacex.ui.rockets.RocketsViewModel
import com.ayo.spacex.di.ViewModelKey
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