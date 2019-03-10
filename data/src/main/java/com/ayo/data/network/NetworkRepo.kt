package com.ayo.data.network

import com.ayo.domain.model.UserDomain
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

abstract class NetworkRepo<T> {

    abstract val db: FirebaseFirestore
    abstract val collectionName: String

    fun addItem(item: T): Long {
        return try {
            val toAdd = HashMap<String, Any>()
            when (item) {
                is UserDomain -> {
                    item.id?.let { toAdd["id"] = it }
                    item.name?.let { toAdd["name"] = it }
                    item.email?.let { toAdd["email"] = it }
                    item.password?.let { toAdd["password"] = it }
                    db.collection(collectionName)
                        .add(toAdd)
                        .addOnSuccessListener { Timber.d("$TAG: successfully added user ${it.id} to remote") }
                        .addOnFailureListener { throw it }
                    item.id ?: -1 //todo can we do this better?
                }
                else -> throw Exception("Item type not recognised")
            }
        } catch (e: Exception) {
            Timber.e("$TAG: error adding user to remote ${e.message}")
            -1L
        }
    }

    @ExperimentalCoroutinesApi
    fun CoroutineScope.getItem(id: Long): ReceiveChannel<Any?> = produce {
        try {
            when (collectionName) {
                "users" -> {
                    db.collection(collectionName).whereEqualTo("id", id).get().addOnCompleteListener {
                        if (it.isSuccessful) {
                            launch { send(it.result?.toObjects(UserDomain::class.java)?.get(0)) }
                        } else {
                            launch { Exception("Failed to get item") }
                        }
                    }
                }
                else -> send(Exception("collection type not recognised"))
            }
        } catch (e: Exception) {
            send(Exception("Failed to get item"))
        }
    }

    companion object {
        private const val TAG = "NetworkRepo"
    }
}