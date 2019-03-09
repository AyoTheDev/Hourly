package com.ayo.api.endpoints

import com.ayo.api.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.GET


interface Api {

    interface User {

        @PUT("/users/{id}.json")
        fun addUserAsync(@Path("id") id: String, @Body data: UserApi): Deferred<Response<UserApi>>

        @GET("/users/{id}.json")
        fun getUserAsync(@Path("id") id: String): Deferred<Response<UserApi>>
    }

    interface Contract {

        @PUT("/contracts/{id}.json")
        fun addContractAsync(@Path("id") id: String, @Body data: ContractApi): Deferred<Response<ContractApi>>

        @GET("/contracts/{id}.json")
        fun getContractAsync(@Path("id") id: String): Deferred<Response<ContractApi>>

    }

    interface Shift {
        @PUT("/contracts/shifts/{id}.json")
        fun addShiftAsync(@Path("id") id: String, @Body data: ShiftApi): Deferred<Response<ShiftApi>>

        @GET("/contracts/shifts/{id}.json")
        fun getShiftAsync(@Path("id") id: String): Deferred<Response<ShiftApi>>

        @GET("/contracts/shifts/{userId}.json")
        fun getShiftsForUserAsync(@Path("userId") userId: String): Deferred<Response<List<ShiftApi>>>

    }


    interface Fence {
        @PUT("/fences/{id}.json")
        fun addFenceAsync(@Path("id") id: String, @Body data: FenceApi): Deferred<Response<FenceApi>>

        @GET("/fences/{id}.json")
        fun getFenceAsync(@Path("id") id: String): Deferred<Response<FenceApi>>

    }

    interface Employer {
        @PUT("/employers/{id}.json")
        fun addEmployerAsync(@Path("id") id: String, @Body data: EmployerApi): Deferred<Response<EmployerApi>>

        @GET("/employers/{id}.json")
        fun getEmployerAsync(@Path("id") id: String): Deferred<Response<EmployerApi>>

    }

    interface Location {
        @PUT("/locations/{id}.json")
        fun addLocationAsync(@Path("id") id: String, @Body data: LocationApi): Deferred<Response<LocationApi>>

        @GET("/locations/{id}.json")
        fun getLocationAsync(@Path("id") id: String): Deferred<Response<LocationApi>>

    }


}