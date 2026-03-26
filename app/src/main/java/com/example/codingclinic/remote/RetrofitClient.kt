package com.example.codingclinic.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofitClient : Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api : API by lazy {
        retrofitClient.create(API::class.java)
    }

}