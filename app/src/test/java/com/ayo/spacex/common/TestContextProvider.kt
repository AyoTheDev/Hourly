package com.ayo.spacex.common

import com.ayo.spacex.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlin.coroutines.CoroutineContext

class TestContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext = Unconfined
    override val io: CoroutineContext = Unconfined
}