package com.example.examenextraordinariapmdm.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Personaje(
    val id: Int,
    @SerializedName("age")
    val edad: Int?,
    @SerializedName("birthdate")
    val fechaNacimiento: String?,
    @SerializedName("gender")
    val genero: String,
    @SerializedName("name")
    val nombre: String,
    @SerializedName("occupation")
    val ocupacion: String,
    @SerializedName("portrait_path")
    val foto: String,
    @SerializedName("phrases")
    val frases: List<String>,
    @SerializedName("status")
    val status: String
): Parcelable