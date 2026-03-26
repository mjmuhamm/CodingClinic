package com.example.codingclinic.di

import com.example.codingclinic.remote.API
import com.example.codingclinic.remote.RetrofitClient
import com.example.codingclinic.remote.RetrofitClient.BASE_URL
import com.example.codingclinic.repository.ClinicRepository
import com.example.codingclinic.repository.ClinicRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApi() : API = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(
        API::class.java)

    @Singleton
    @Provides
    fun provideRepository(api : API) : ClinicRepository = ClinicRepositoryImpl(api)

}
