package com.example.recuperacinpmdm_estebanmontes.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.recuperacinpmdm_estebanmontes.model.Estados

class MyVIewModel {
    /**
     * Variable estado que recoge los distintos estados del juego
     */
    val estadoLiveData = MutableLiveData<Estados?>()

}