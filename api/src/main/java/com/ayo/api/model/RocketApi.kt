package com.ayo.api.model


data class RocketApi(
    val rocketid: Long?,
    val name: String?,
    val country: String?,
    val engines: EngineApi?,
    val description: String?
)