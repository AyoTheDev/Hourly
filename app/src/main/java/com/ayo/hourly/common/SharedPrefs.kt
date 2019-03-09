package com.ayo.hourly.common

import android.content.Context
import android.content.SharedPreferences

private const val PREF_FILENAME = "ayo.com.spaceX"
private const val FIRST_LAUNCH = "first_launch"
private const val ROCKET_CACHE = "rocket_cache"

class SharedPrefs(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(PREF_FILENAME, 0)

    var isFirstLaunch: Boolean
        get() = prefs.getBoolean(FIRST_LAUNCH, true)
        set(value) = prefs.edit().putBoolean(FIRST_LAUNCH, value).apply()

}