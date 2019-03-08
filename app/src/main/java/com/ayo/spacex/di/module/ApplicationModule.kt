package com.ayo.spacex.di.module

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import com.ayo.spacex.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideCoroutineContext(): CoroutineContextProvider {
        return CoroutineContextProvider()
    }

    @Singleton
    @Provides
    fun provideContext(): Context = context

    @Provides
    fun bindNotificationManager(): NotificationManagerCompat = NotificationManagerCompat.from(context)

}