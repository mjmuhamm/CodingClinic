package com.example.codingclinic.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.codingclinic.model.CodingClinicResponseItem
import com.example.codingclinic.repository.ClinicRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClinicViewModel @Inject constructor(private val repository : ClinicRepositoryImpl ) : ViewModel() {

    private val _state = MutableStateFlow<List<CodingClinicResponseItem>>(emptyList())
    val state = _state.asStateFlow()

    init {
        getInfo()
    }

    fun getInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getInfo()
            _state.value = response
        }
    }

}
