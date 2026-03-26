package com.example.codingclinic.remote

import com.example.codingclinic.model.CodingClinicResponseItem
import retrofit2.http.GET

interface API {

    @GET("users")
    suspend fun getInfo() : List<CodingClinicResponseItem>
}