package com.example.cepsearcherflow.api

import com.example.cepsearcherflow.model.Cep
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import retrofit2.Retrofit

class CepApi(private val retrofit: Retrofit) {
    private val service: CepService by lazy {
        retrofit.create(CepService::class.java)
    }

    fun getAddress(cep: String): Flow<Cep> {
        return channelFlow {
            send(service.getAddress(cep))
        }
    }
}