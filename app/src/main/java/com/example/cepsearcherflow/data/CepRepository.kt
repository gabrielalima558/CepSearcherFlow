package com.example.cepsearcherflow.data

import com.example.cepsearcherflow.api.CepApi

class CepRepository(private val api: CepApi) {
    fun getAdrress(cep: String) = api.getAddress(cep)
}