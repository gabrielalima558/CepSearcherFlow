package com.example.cepsearcherflow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cepsearcherflow.api.CepApi
import com.example.cepsearcherflow.api.RetrofitBuilder
import com.example.cepsearcherflow.data.CepRepository

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val retrofit = RetrofitBuilder.retrofit

    private val cepApi = CepApi(retrofit)

    private val cepRepository =
        CepRepository(cepApi)

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            cepRepository
        ) as T
    }
}