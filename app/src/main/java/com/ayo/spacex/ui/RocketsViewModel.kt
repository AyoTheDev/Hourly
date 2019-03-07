package com.ayo.spacex.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayo.spacex.CoroutineContextProvider
import com.ayo.data.local.SharedPrefs
import com.ayo.data.remote.model.Rocket
import com.ayo.data.repository.RocketsRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RocketsViewModel @Inject constructor(
    private val repository: RocketsRepository,
    sharedPrefs: SharedPrefs,
    private val coroutineContextProvider: CoroutineContextProvider
) : ViewModel(), CoroutineScope {

    private val jobs = mutableListOf<Job>() //move to a base class
    override val coroutineContext: CoroutineContext = coroutineContextProvider.main
    val event = MutableLiveData<Event>()


    init {
        if (sharedPrefs.isFirstLaunch) {
            event.value = Event.ShowWelcomeMessage
            sharedPrefs.isFirstLaunch = false
        }
    }


    fun loadRocketList(forceRefresh: Boolean = false) {
        event.value = Event.RocketList(true, null, null)
        jobs.add(launch(context = coroutineContextProvider.io) {
            event.postValue(
                try {
                    Event.RocketList(false, repository.getRockets(forceRefresh), null)
                } catch (e: Exception) {
                    Event.RocketList(false, null, e)
                }
            )
        })
    }

    fun cancelActiveJobs() {
        jobs.forEach { it.cancel() }
    }

    /**
     * To improve: here we could wrap the loading, error and rocket list data and then have the UI
     * listen to that
     */
    sealed class Event {
        data class RocketList(val loading: Boolean?, val data: List<Rocket>?, val exception: Exception?) : Event()
        object ShowWelcomeMessage : Event()
    }


}