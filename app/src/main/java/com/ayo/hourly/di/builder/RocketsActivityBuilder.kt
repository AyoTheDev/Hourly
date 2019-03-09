package com.ayo.hourly.di.builder

import com.ayo.hourly.ui.rockets.RocketsActivity
import com.ayo.hourly.di.module.RocketsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module interface RocketsActivityBuilder {
    @ContributesAndroidInjector(modules = [RocketsModule::class])
    fun contributeRocketsActivity(): RocketsActivity
}