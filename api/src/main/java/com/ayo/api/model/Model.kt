package com.ayo.api.model

data class UserApi (
    val id: Long?,
    val name: String?,
    val email: String?,
    val password: String? //todo do we need this?
)

data class ShiftApi(
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

data class FenceApi(
    val id: Long?,
    val enter : Boolean?,
    val locationId: String?
)

data class EmployerApi(
    val id: Long?,
    val imageUrl: String?,
    val name: String?
)

data class LocationApi(
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

data class ContractApi(
    val id: Long?,
    val wage: Int,
    val currency: String,
    val breaksEnabled: Boolean,
    val breakSettingMinutes: Int,
    val breakSettingHoursInMinutes: Int,
    val userId: String,
    val employerId: String
)