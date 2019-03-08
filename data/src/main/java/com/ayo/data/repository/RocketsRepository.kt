package com.ayo.data.repository

import com.ayo.data.db.RocketsDao
import com.ayo.data.db.model.Rocket
import com.ayo.api.services.RocketsService
import com.ayo.domain.model.EngineDomain
import com.ayo.domain.model.RocketDomain
import com.ayo.domain.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class RocketsRepository @Inject constructor(
    private val remoteSource: RocketsService,
    private val localSource: RocketsDao
) : Repository<RocketDomain> {

    @ExperimentalCoroutinesApi
    override suspend fun getAll(forceRefresh: Boolean): List<RocketDomain>? {
        return when {
            forceRefresh || getLocalData().isNullOrEmpty() -> getRemoteData()
            else -> getLocalData()
        }
    }

    override suspend fun addAll(list: List<RocketDomain>) =
        localSource
            .insertRockets(
                list.map {
                    Rocket(
                        rocketid = it.rocketid, name = it.name,
                        country = it.country, description = it.description
                    )
                })

    @ExperimentalCoroutinesApi
    private suspend fun getRemoteData() =
        remoteSource.getRockets()
            ?.map {
                RocketDomain(
                    rocketid = it.rocketid, name = it.name, country = it.country,
                    description = it.description, engines = EngineDomain(it.engines?.number)
                )
            }
            ?.apply { addAll(this) }

    @ExperimentalCoroutinesApi
    private suspend fun getLocalData() =
        localSource.getRockets().map {
            RocketDomain(
                rocketid = it.rocketid, name = it.name, country = it.country,
                description = it.description, engines = EngineDomain(1)
            )
        }


}

