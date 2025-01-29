package com.example.recuperacinpmdm_estebanmontes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recuperacinpmdm_estebanmontes.model.Datos
import com.example.recuperacinpmdm_estebanmontes.model.Estados

class MyVIewModel {
    /**
     * Variable estado que recoge los distintos estados del juego
     * La inicializamos en el estado "INICIO"
     */
    val estadoLiveData: MutableLiveData<Estados?> = MutableLiveData(Estados.INICIO)

    private val _palabra = MutableLiveData<String>()
    val palabra: LiveData<String> get() = _palabra

    // Pista actual
    private val _pistaActual = MutableLiveData<String>()
    val pistaActual: LiveData<String> get() = _pistaActual

    private var indicePista = 0

    /**
     * Funcion para iniciar la partida
     */
    fun iniciarPartida(){
        Datos.palabra = Datos.palabrasYPistas.keys.random()
        Datos.pistas = Datos.palabrasYPistas[Datos.palabra] ?: listOf()
        _palabra.value = Datos.palabra

        indicePista = 0
        _pistaActual.value = Datos.pistas.getOrNull(indicePista)

        estadoLiveData.value = Estados.ADIVINANDO
    }

    /**
     * Funcion que muestra la siguiente pista
     */
    fun siguientePista(){
        if (indicePista < Datos.pistas.size - 1){
            indicePista++
            _pistaActual.value = Datos.pistas[indicePista]
        }
    }
    fun adivinarPalabra(intento: String) {
        if (Datos.intentos < 2) {
            if (intento.equals(Datos.palabra, ignoreCase = true)) {
                // Si acierta, reseteamos intentos y mostramos mensaje
                Datos.intentos = 0
                estadoLiveData.value = Estados.INICIO // Volver al estado INICIO (pantalla de inicio)
            } else {
                // Si falla, aumenta intentos y muestra nueva pista
                Datos.intentos++
                siguientePista()
            }
        } else {
            // Si falla 3 veces, reiniciamos el juego
            Datos.intentos = 0
            estadoLiveData.value = Estados.INICIO // Vuelve a la pantalla de inicio
        }
    }
}