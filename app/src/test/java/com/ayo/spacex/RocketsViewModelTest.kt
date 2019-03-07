package com.ayo.spacex

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import com.ayo.data.local.SharedPrefs
import com.ayo.data.repository.RocketsRepository
import com.ayo.spacex.ui.RocketsViewModel
import com.ayo.spacex.utils.TestContextProvider
import kotlinx.coroutines.*
import org.junit.After
import org.junit.Assert
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LifecycleOwner
import org.junit.rules.TestRule
import org.junit.Rule
import org.mockito.Mockito.`when`


class RocketsViewModelTest {

    private lateinit var underTest: RocketsViewModel

    @Mock
    private lateinit var repository: RocketsRepository
    @Mock
    private lateinit var prefs: SharedPrefs
    @Mock
    private lateinit var eventObserver: Observer<RocketsViewModel.Event>
    @Mock
    lateinit var lifecycleOwner: LifecycleOwner

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var lifecycle : LifecycleRegistry


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        lifecycle = LifecycleRegistry(lifecycleOwner)
        underTest = RocketsViewModel()
        underTest.initiate(repository, prefs, TestContextProvider())
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        underTest.event.observeForever(eventObserver)
    }

    @After
    fun finish() {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    @Test
    fun rocket_list_data_state() = runBlocking {

        //GIVEN

        //WHEN
        underTest.loadRocketList()

        //THEN
        Assert.assertTrue(
                underTest.event.value ==
                        RocketsViewModel.Event.RocketList(false, repository.getRockets(), null)
        )
    }

//    @Test
//    fun rocket_list_loading_state() = runBlocking {
//        //GIVEN
//
//        //WHEN
//        underTest.loadRocketList()
//
//        //THEN
//        Assert.assertTrue(
//                underTest.event.value ==
//                        RocketsViewModel.Event.RocketList(true, null, null)
//        )
//    }
//
//    @Test
//    fun rocket_list_error_state() = runBlocking {
//
//    }
//
//
//    @Test
//    fun load_rocket_list() {
//        //GIVEN
//        val forceRefresh = false
//        underTest.event.observeForever(eventObserver)
//
//        //WHEN
//        underTest.loadRocketList(forceRefresh)
//
//        //THEN
//        launch {
//            Mockito.verify(repository).getRockets(forceRefresh)
//            val captor = ArgumentCaptor.forClass(RocketsViewModel.Event::class.java)
//            Mockito.verify(eventObserver).onChanged(MockitoKotlinHelpers.capture(captor))
//            //Assert.assertTrue(captor.value is RocketsViewModel.Event.Loading)
//
//        }
//
//
//    }
//
//    private inline fun <reified T> lambdaMock(): T = mock(T::class.java)

}
