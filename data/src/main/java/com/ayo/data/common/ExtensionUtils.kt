package com.ayo.data.common

import com.ayo.api.model.RocketApi
import com.ayo.data.db.model.RocketData
import com.ayo.domain.model.EngineDomain
import com.ayo.domain.model.RocketDomain


/**
 * Mappers for rocket data models
 */
fun RocketDomain.toData(): RocketData {
    return RocketData(
        rocketid = this.rocketid, name = this.name,
        country = this.country, description = this.description
    )
}

fun RocketApi.toDomain(): RocketDomain {
    return RocketDomain(
        rocketid = this.rocketid, name = this.name, country = this.country,
        description = this.description, engines = EngineDomain(this.engines?.number)
    )
}

fun RocketData.toDomain(): RocketDomain {
    return RocketDomain(
        rocketid = this.rocketid, name = this.name, country = this.country,
        description = this.description, engines = EngineDomain(1)
    )
}