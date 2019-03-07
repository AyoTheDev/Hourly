package com.ayo.spacex.usecase

import com.ayo.data.repository.RocketsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RocketsUseCase @Inject constructor(private val repository: RocketsRepository) {

    suspend fun getRockets(forceRefresh: Boolean = false) = repository.getRockets(forceRefresh)

}