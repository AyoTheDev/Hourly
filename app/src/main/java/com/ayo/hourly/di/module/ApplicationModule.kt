package com.ayo.hourly.di.module

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import com.ayo.hourly.common.CoroutineContextProvider
import com.ayo.hourly.common.SharedPrefs
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

    @Singleton
    @Provides
    fun provideSharedPrefs(context: Context): SharedPrefs {
        return SharedPrefs(context)
    }

    @Provides
    fun bindNotificationManager(): NotificationManagerCompat = NotificationManagerCompat.from(context)

}