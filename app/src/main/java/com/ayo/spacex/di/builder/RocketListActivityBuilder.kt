package com.ayo.spacex.di.builder

import com.ayo.spacex.ui.RocketsActivity
import com.ayo.spacex.di.module.RocketsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module interface RocketListActivityBuilder {
    @ContributesAndroidInjector(modules = [RocketsModule::class])
    fun contributeRocketsActivity(): RocketsActivity
}