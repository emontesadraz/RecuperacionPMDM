package com.example.recuperacinpmdm_estebanmontes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.recuperacinpmdm_estebanmontes.ui.theme.RecuperaciónPMDM_EstebanMontesTheme
import com.example.recuperacinpmdm_estebanmontes.view.MyApp
import com.example.recuperacinpmdm_estebanmontes.viewmodel.MyVIewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val miVIewModel: MyVIewModel = MyVIewModel()
        enableEdgeToEdge()
        setContent {
            RecuperaciónPMDM_EstebanMontesTheme {
                MyApp(miVIewModel)
            }
        }
    }
}
