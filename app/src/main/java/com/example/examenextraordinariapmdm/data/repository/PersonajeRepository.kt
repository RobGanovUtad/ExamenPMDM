package com.example.examenextraordinariapmdm.data.repository

import com.example.examenextraordinariapmdm.data.model.Personaje
import com.example.examenextraordinariapmdm.data.network.RetrofitClient

class PersonajeRepository {
    suspend fun obtenerPersonajes () : Result<List<Personaje>> {
        return try {
            val response = RetrofitClient.apiService.getPersonajes()
            if (response.isSuccessful) {
                Result.success(response.body().orEmpty())
            } else {
                Result.failure(Exception("Error HTTP ${response.code()}"))
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}