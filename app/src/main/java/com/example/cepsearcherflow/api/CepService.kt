package com.example.cepsearcherflow.api

import com.example.cepsearcherflow.model.Cep
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET("/ws/{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): Cep
}