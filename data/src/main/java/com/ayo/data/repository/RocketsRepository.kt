package com.ayo.data.repository

import com.ayo.data.local.SharedPrefs
import com.ayo.data.remote.model.Rocket
import com.ayo.data.remote.services.RocketsService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class RocketsRepository @Inject constructor(
    private val remote: RocketsService,
    private val local: SharedPrefs
) {

    suspend fun getRockets(forceRefresh: Boolean = false): List<Rocket>? {
        return local.cachedData?.let {
            if (it == "" || forceRefresh) {
                val list = getRemoteData()
                cacheData(list)
                list
            } else getCachedData(it)
        }
    }

    private fun cacheData(list: List<Rocket>?) {
        local.cachedData = Gson().toJson(list)
    }

    private suspend fun getRemoteData() = remote.getRockets()

    private fun getCachedData(data: String) =
        Gson().fromJson<List<Rocket>>(data, object : TypeToken<List<Rocket>>() {}.type)


}

