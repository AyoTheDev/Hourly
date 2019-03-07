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
            forceRefresh -> getRemoteData()
            !getLocalData().isNullOrEmpty() -> getLocalData()
            else -> getRemoteData()
        }
    }

    private fun insertRockets(list: List<Rocket>) = localSource.insertRockets(list)

    @ExperimentalCoroutinesApi
    private suspend fun getRemoteData() =
        remoteSource.getRockets()?.apply { insertRockets(this) }

    @ExperimentalCoroutinesApi
    private suspend fun getLocalData() = localSource.getRocketsAsync().getCompleted()

    //todo think about adding a caching policy


}

