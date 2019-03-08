package com.ayo.spacex.ui.rockets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayo.spacex.common.CoroutineContextProvider
import com.ayo.spacex.common.SharedPrefs
import com.ayo.domain.model.RocketDomain
import com.ayo.spacex.common.SingleLiveEvent
import com.ayo.spacex.common.Resource
import com.ayo.domain.usecase.RocketsUseCase
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RocketsViewModel @Inject constructor(
    private val rocketsUseCase: RocketsUseCase,
    private val coroutineContextProvider: CoroutineContextProvider,
    sharedPrefs: SharedPrefs
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = coroutineContextProvider.main
    private val jobs = mutableListOf<Job>()

    val event = MutableLiveData<UiEvent>()
    val rocketsLiveData = SingleLiveEvent<Resource<List<RocketDomain>>>()

    init {
        if (sharedPrefs.isFirstLaunch) {
            event.value = UiEvent.ShowWelcomeMessage
            sharedPrefs.isFirstLaunch = false
        }
    }

    @ExperimentalCoroutinesApi
    fun loadRocketList(forceRefresh: Boolean = false) {
        rocketsLiveData.value = Resource.loading()
        jobs.add(launch(context = coroutineContextProvider.io) {
            rocketsLiveData.postValue(
                try {
                    Resource.success(rocketsUseCase.getRockets(forceRefresh))
                } catch (e: Exception) {
                    Resource.error(msg = e.message ?: "Error", data = null)
                }
            )
        })
    }

    fun cancelActiveJobs() {
        jobs.forEach { it.cancel() }
    }

    sealed class UiEvent {
        object ShowWelcomeMessage : UiEvent()
    }


}