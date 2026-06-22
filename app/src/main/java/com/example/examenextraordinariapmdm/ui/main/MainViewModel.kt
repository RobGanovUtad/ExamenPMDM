package com.example.examenextraordinariapmdm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.examenextraordinariapmdm.data.model.Personaje
import com.example.examenextraordinariapmdm.data.repository.PersonajeRepository

class MainViewModel(
    private val repository: PersonajeRepository
) : ViewModel() {

    private val _personajes = MutableLiveData<List<Personaje>>()
    val paises: LiveData<List<Personaje>> = _personajes

    private val _cargando = MutableLiveData(false)
    val cargando: LiveData<Boolean> = _cargando

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error


    fun cargarPersonajes() {
        _cargando.value = true
        _error.value = null

        // Se usa corrutina en viewModelScope para respetar ciclo de vida de la pantalla.
        viewModelScope.launch {
            val resultado = repository.obtenerPersonajes()
            resultado
                .onSuccess { _personajes.value = it }
                .onFailure { _error.value = it.message }

            _cargando.value = false
        }
    }
}