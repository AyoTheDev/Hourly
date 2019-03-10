package com.ayo.data.repository

import com.ayo.data.local.dao.RocketsDao
import com.ayo.api.services.RocketsService
import com.ayo.data.common.toData
import com.ayo.data.common.toDomain
import com.ayo.domain.model.RocketDomain
import com.ayo.domain.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class RocketsRepository @Inject constructor(
    private val remoteSource: RocketsService,
    private val localSource: RocketsDao
) : Repository<RocketDomain> {


    override suspend fun add(data: RocketDomain): Long {
        return -1L
    }

    override suspend fun get(id: Long): RocketDomain? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @ExperimentalCoroutinesApi
    override suspend fun getAll(forceRefresh: Boolean): List<RocketDomain>? {
        return when {
            forceRefresh || getLocalData().isNullOrEmpty() -> getRemoteData()
            else -> getLocalData()
        }
    }

    override suspend fun addAll(list: List<RocketDomain>) : List<Long> =
        localSource.insertRockets(list.map { rocket -> rocket.toData() })

    @ExperimentalCoroutinesApi
    private suspend fun getRemoteData() =
        remoteSource.getRockets()
            ?.map { rocket -> rocket.toDomain() }
            ?.apply { addAll(this) }

    @ExperimentalCoroutinesApi
    private suspend fun getLocalData() =
        localSource.getRockets()
            .map { rocket -> rocket.toDomain() }


}

