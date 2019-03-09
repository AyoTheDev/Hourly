package com.ayo.api.services

import com.ayo.api.endpoints.Api
import com.ayo.api.handler.ResponseHandler
import com.ayo.api.model.ContractApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class ContractService @Inject constructor(private var api: Api.Contract) {

    @ExperimentalCoroutinesApi
    suspend fun getContract(id: Long): ContractApi? {
        val responseHandler = ResponseHandler(api.getContractAsync(id.toString()))
        responseHandler.run()
        return responseHandler.response()
    }

    @ExperimentalCoroutinesApi
    suspend fun addContract(contractApi: ContractApi) {
        val responseHandler = ResponseHandler(api.addContractAsync(contractApi.id.toString(), contractApi))
        responseHandler.run()
    }


}