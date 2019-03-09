package com.ayo.domain.usecase

import com.ayo.domain.model.RocketDomain
import com.ayo.domain.model.UserDomain
import com.ayo.domain.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserUseCase @Inject constructor
    (private val userRepository: Repository<UserDomain>) {

    suspend fun getUser(id: Long) = userRepository.get(id)

    suspend fun addUser(user: UserDomain) = userRepository.add(user)

}