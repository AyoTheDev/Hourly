package com.ayo.domain.model

data class RocketDomain (
    val rocketid: Long?,
    val name: String?,
    val country: String?,
    val engines: EngineDomain?,
    val description: String?
)