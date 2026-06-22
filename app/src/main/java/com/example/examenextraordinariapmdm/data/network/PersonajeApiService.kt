package com.example.examenextraordinariapmdm.data.network

import com.example.examenextraordinariapmdm.data.model.Personaje
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonajeApiService {

    @GET("")
    suspend fun getPersonajes(): Response<List<Personaje>>
}