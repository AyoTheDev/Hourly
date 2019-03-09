package com.ayo.domain.model

data class UserDomain (
    val id: Long? = null,
    val name: String?,
    val email: String?,
    val password: String? //todo do we need this?
)

data class ShiftDomain(
    val id: Long?,
    val employerId: String?,
    val userId: String?,
    val fenceId: String?,
    val contractId : String?,
    val timeWorked: Long?,
    val breakTime: Long?,
    val start: Long?,
    val finish: Long?,
    val isComplete: Boolean?,
    val addedManually: Boolean?,
    val wage: Int?
)

data class FenceDomain(
    val id: Long?,
    val enter : Boolean?,
    val locationId: String?
)

data class EmployerDomain(
    val id: Long?,
    val imageUrl: String?,
    val name: String?
)

data class LocationDomain(
    val id: Long?,
    val lat: Double?,
    val lng: Double?,
    val radius: Double?,
    val employerId: String?,
    val address: String?,
    //these will constantly be updating...
    val clockInFenceId: String?,
    val clockOutFenceId: String?
)

data class ContractDomain(
    val id: Long?,
    val wage: Int?,
    val currency: String?,
    val breaksEnabled: Boolean?,
    val breakSettingMinutes: Int?,
    val breakSettingHoursInMinutes: Int?,
    val userId: String?,
    val employerId: String?
)