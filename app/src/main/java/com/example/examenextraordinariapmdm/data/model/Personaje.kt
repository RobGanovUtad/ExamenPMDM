package com.example.examenextraordinariapmdm.data.model

import android.os.Parcelable
import android.os.Parcel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*
Unresolved reference 'parcelize'.
Unresolved reference 'Parcelize'.
<html>Class 'Personaje' is not abstract and does not implement abstract members:<br/>fun describeContents(): Int<br/>fun writeToParcel(dest: Parcel, flags: Int): Unit
This class implements `Parcelable` but does not provide a `CREATOR` field
 */


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
): Parcelable {
    private constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        edad = parcel.readValue(Int::class.java.classLoader) as? Int,
        fechaNacimiento = parcel.readString(),
        genero = parcel.readString() ?: "",
        nombre = parcel.readString() ?: "",
        ocupacion = parcel.readString() ?: "",
        foto = parcel.readString() ?: "",
        frases = parcel.createStringArrayList() ?: emptyList(),
        status = parcel.readString() ?: ""
    )
}