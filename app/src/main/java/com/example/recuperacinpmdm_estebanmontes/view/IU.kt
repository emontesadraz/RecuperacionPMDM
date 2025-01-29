package com.example.recuperacinpmdm_estebanmontes.view

import android.text.Layout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.recuperacinpmdm_estebanmontes.model.Estados
import com.example.recuperacinpmdm_estebanmontes.viewmodel.MyVIewModel

/**
 * Esta es la función principal de la aplicación.
 * La que va a ver el usuario
 */
@Composable
fun MyApp(MyViewModel: MyVIewModel){
    // Obtenemos el estado actual
    val estado by MyViewModel.estadoLiveData.observeAsState(Estados.INICIO)

    when (estado) {
        Estados.INICIO -> PantallaInicio(MyViewModel)
        Estados.ADIVINANDO -> PantallaJuego(MyViewModel)
        else -> {}
    }
}

/**
 * Funcio de bienvenida
 */
@Composable
fun PantallaInicio(MyViewModel: MyVIewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Bienvenido al juego", fontSize = 24.sp)
        Button(onClick = { MyViewModel.iniciarPartida() }) {
            Text("Comenzar Juego")
        }
    }
}

/**
 * Funcion para la pantalla donde se desarrolla el juego
 */
@Composable
fun PantallaJuego(MyViewModel: MyVIewModel) {
    var palabraUsuario by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Adivina la palabra", fontSize = 24.sp)

        // Muestra la pista actual
        MyViewModel.pistaActual.value?.let { pista ->
            Text(text = "Pista: $pista", fontSize = 18.sp)
        }

        // Campo de texto para ingresar la palabra
        OutlinedTextField(
            value = palabraUsuario,
            onValueChange = { palabraUsuario = it },
            label = { Text("Escribe tu respuesta") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para enviar la palabra ingresada
        Button(onClick = {
            MyViewModel.adivinarPalabra(palabraUsuario)
            palabraUsuario = "" // Limpia el campo después de enviar
        }) {
            Text("Enviar Respuesta")
        }
    }
}
@Preview
@Composable
fun IUPreview(){
    MyApp(MyVIewModel())
}