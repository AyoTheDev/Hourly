package com.ayo.domain.usecase

import com.ayo.domain.model.RocketDomain
import com.ayo.domain.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RocketsUseCase @Inject constructor
    (private val rocketsRepository: Repository<RocketDomain>) {

    @ExperimentalCoroutinesApi
    suspend fun getRockets(forceRefresh: Boolean = false) = rocketsRepository.getAll(forceRefresh)

}