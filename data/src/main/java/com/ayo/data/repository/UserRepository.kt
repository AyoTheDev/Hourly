package com.ayo.data.repository

import com.ayo.data.common.toData
import com.ayo.data.common.toDomain
import com.ayo.data.local.dao.UserDao
import com.ayo.data.network.UserNetworkRepo
import com.ayo.domain.model.UserDomain
import com.ayo.domain.repository.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteSource: UserNetworkRepo,
    private val localSource: UserDao
) : Repository<UserDomain> {


    @ExperimentalCoroutinesApi
    override suspend fun add(data: UserDomain): Long {
        val userId = localSource.addUser(data.toData())
            .apply { Timber.d("$TAG: successfully added user $this to local") }
        addToRemote(data.copy(id = userId))
        return userId
    }

    @ExperimentalCoroutinesApi
    override suspend fun get(id: Long): UserDomain? {
        val local = getLocalData(id)
        return when {
            local.isEmpty() -> getRemoteData(id)
            else -> local[0].toDomain()
        }

    }

    override suspend fun getAll(forceRefresh: Boolean): List<UserDomain>? {
        return null
    }

    override suspend fun addAll(list: List<UserDomain>): List<Long> {
        return emptyList()
    }


    private suspend fun addToRemote(data: UserDomain) = remoteSource.add(data)

    @ExperimentalCoroutinesApi
    private suspend fun getRemoteData(id: Long) = remoteSource.get(id)?.apply { localSource.addUser(this.toData()) }

    private suspend fun getLocalData(id: Long) =
        localSource.getUser(id)
            .apply {
                Timber.d("$TAG: successfully retrieved ${this[0].id} from local")
            }


    companion object {
        private val TAG = UserRepository::class.java.simpleName
    }
}

