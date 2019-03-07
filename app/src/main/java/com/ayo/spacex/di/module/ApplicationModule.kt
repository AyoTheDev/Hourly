package com.ayo.spacex.di.module

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context = context

    @Provides
    fun bindNotificationManager(): NotificationManagerCompat = NotificationManagerCompat.from(context)

}