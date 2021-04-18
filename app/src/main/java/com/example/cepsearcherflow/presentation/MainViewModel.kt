package com.example.cepsearcherflow.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cepsearcherflow.data.CepRepository
import com.example.cepsearcherflow.model.Cep
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CepRepository) : ViewModel() {
    private var _cep = MutableLiveData<Cep>()
    val cep: LiveData<Cep> get() = _cep

    fun getAddress(cep: String) {
        viewModelScope.launch {
            repository.getAdrress(cep).collect {
                _cep.value = it
            }
        }
    }
}
