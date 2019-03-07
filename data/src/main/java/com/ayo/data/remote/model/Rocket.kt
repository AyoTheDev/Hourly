package com.ayo.data.remote.model

import com.ayo.data.local.model.Engine

data class Rocket(
    val name: String?,
    val country: String?,
    val engines: Engine?,
    val description: String?
)