package com.example.codingclinic.repository

import com.example.codingclinic.model.CodingClinicResponseItem
import com.example.codingclinic.remote.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClinicRepositoryImpl @Inject constructor(private val api : API) : ClinicRepository {
    override suspend fun getInfo(): List<CodingClinicResponseItem> = withContext(Dispatchers.IO) {
        api.getInfo()
    }
}