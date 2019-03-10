package com.ayo.data.network

import com.ayo.domain.model.UserDomain
import com.ayo.domain.repository.Repository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class UserNetworkRepo @Inject constructor(firestore: FirebaseFirestore):
    Repository<UserDomain>, NetworkRepo<UserDomain>() {

    override val db = firestore
    override val collectionName = "users"

    override suspend fun getAll(forceRefresh: Boolean): List<UserDomain>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addAll(list: List<UserDomain>): List<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun add(data: UserDomain) = addItem(data)

    @ExperimentalCoroutinesApi
    override suspend fun get(id: Long): UserDomain? {
        return runBlocking {
            try {
                getItem(id).receive() as UserDomain
            } catch (e: Exception) {
                Timber.e(e)
                null
            }
        }
    }

}


