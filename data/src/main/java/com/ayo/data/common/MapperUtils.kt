package com.ayo.data.common

import com.ayo.api.model.RocketApi
import com.ayo.api.model.UserApi
import com.ayo.data.db.model.RocketData
import com.ayo.data.db.model.UserData
import com.ayo.domain.model.EngineDomain
import com.ayo.domain.model.RocketDomain
import com.ayo.domain.model.UserDomain


/**
 * Mappers for user data models
 */
fun UserDomain.toData(): UserData {
    return UserData(
        name = this.name,
        email = this.email, password = this.password
    )
}

fun UserApi.toDomain(): UserDomain {
    return UserDomain(
        id = this.id, name = this.name,
        email = this.email, password = this.password
    )
}

fun UserData.toDomain(): UserDomain {
    return UserDomain(
        id = this.id, name = this.name,
        email = this.email, password = this.password
    )
}

fun UserDomain.toApi(id: Long): UserApi {
    return UserApi(
        id = id, name = this.name,
        email = this.email, password = this.password
    )
}


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