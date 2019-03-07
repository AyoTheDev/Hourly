package com.ayo.api.model


data class Rocket(
    val rocketid: Long?,
    val name: String?,
    val country: String?,
    val engines: Engine?,
    val description: String?
)