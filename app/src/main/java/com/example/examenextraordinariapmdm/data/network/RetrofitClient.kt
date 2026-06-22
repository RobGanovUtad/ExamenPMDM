package com.example.examenextraordinariapmdm.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://thesimpsonsapi.com/api"

    val apiService: PersonajeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PersonajeApiService::class.java)
    }
}