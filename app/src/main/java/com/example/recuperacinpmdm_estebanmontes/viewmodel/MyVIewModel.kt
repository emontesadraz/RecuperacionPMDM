package com.example.recuperacinpmdm_estebanmontes.viewmodel

import android.content.Context
import android.widget.Toast
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

    /**
     * Funcion que compara las palabras escritas por el usuario con la palabra random
     * @param intento son los intentos que tiene el jugador
     * @param context permite utilizar el toast para los mensajes
     */
    fun adivinarPalabra(intento: String, context: Context) {
        if (Datos.intentos < 2) { // Permitimos 3 intentos (0,1,2)
            if (intento.equals(Datos.palabra, ignoreCase = true)) {
                // Si acierta, mostramos un Toast y reseteamos intentos
                Datos.intentos = 0
                estadoLiveData.value = Estados.INICIO
                Toast.makeText(context, "¡Has acertado!", Toast.LENGTH_SHORT).show()
            } else {
                // Si falla, aumenta intentos y muestra nueva pista
                Datos.intentos++
                siguientePista()
            }
        } else {
            // Si falla 3 veces, mostramos un Toast y reiniciamos el juego
            Datos.intentos = 0
            estadoLiveData.value = Estados.INICIO
            Toast.makeText(context, "¡Te has quedado sin intentos!", Toast.LENGTH_SHORT).show()
        }
    }

}