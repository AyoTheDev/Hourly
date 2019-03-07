package com.ayo.data.repository

import com.ayo.data.local.RocketsDao
import com.ayo.data.local.model.Rocket
import com.ayo.data.remote.services.RocketsService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class RocketsRepository @Inject constructor(
    private val remoteSource: RocketsService,
    private val localSource: RocketsDao
) {

    @ExperimentalCoroutinesApi
    suspend fun getRockets(forceRefresh: Boolean = false): List<Rocket>? {
        return when {
            forceRefresh || getLocalData().isNullOrEmpty() -> getRemoteData()
            else -> getLocalData()
        }
    }

    private suspend fun insertRockets(list: List<Rocket>) = localSource.insertRockets(list)

    @ExperimentalCoroutinesApi
    private suspend fun getRemoteData() =
        remoteSource.getRockets()
            ?.map { Rocket(rocketid = it.rocketid, name = it.name, country = it.country, description = it.description) }
            ?.apply { insertRockets(this) }

    @ExperimentalCoroutinesApi
    private suspend fun getLocalData() = localSource.getRockets()

    //todo think about adding a caching policy


}

