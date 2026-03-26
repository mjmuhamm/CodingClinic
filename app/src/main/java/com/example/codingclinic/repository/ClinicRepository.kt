package com.example.codingclinic.repository

import com.example.codingclinic.model.CodingClinicResponseItem

interface ClinicRepository {
    suspend fun getInfo() : List<CodingClinicResponseItem>
}