package com.ayo.spacex.ui.rockets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayo.spacex.CoroutineContextProvider
import com.ayo.spacex.SharedPrefs
import com.ayo.data.db.model.Rocket
import com.ayo.spacex.usecase.RocketsUseCase
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RocketsViewModel @Inject constructor(
    private val rocketsUseCase: RocketsUseCase,
    private val coroutineContextProvider: CoroutineContextProvider,
    sharedPrefs: SharedPrefs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = coroutineContextProvider.main
    private val jobs = mutableListOf<Job>() //move to a base class
    val event = MutableLiveData<Event>()

    init {
        if (sharedPrefs.isFirstLaunch) {
            event.value = Event.ShowWelcomeMessage
            sharedPrefs.isFirstLaunch = false
        }
    }


    @ExperimentalCoroutinesApi
    fun loadRocketList(forceRefresh: Boolean = false) {
        event.value = Event.RocketList(true, null, null)
        jobs.add(launch(context = coroutineContextProvider.io) {
            event.postValue(
                try {
                    Event.RocketList(
                        false,
                        rocketsUseCase.getRockets(forceRefresh),
                        null
                    )
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