package com.example.recuperacinpmdm_estebanmontes.model

object Datos {
    val palabrasYPistas: Map<String, List<String>> = mapOf(
        "Elefante" to listOf("Es un animal", "Tiene trompa", "Es el mamífero terrestre más grande"),
        "Mar" to listOf("Es azul", "Contiene peces", "Tiene olas"),
        "Montaña" to listOf("Es alta", "Tiene nieve en la cima", "Los alpinistas la escalan"),
        "Fuego" to listOf("Es caliente", "Puede quemar", "Se usa para cocinar"),
    )
    var palabra: String = palabrasYPistas.keys.random() // Esto hace que seleccione una palabra aleatoria
    var pistas: List<String> = palabrasYPistas[palabra] ?: listOf() // Esto mostrará las pistas de la palabra random
    var intentos: Int = 0

}
/**
 * Estados del juego
 * INICIO: estado inicial
 * GENERANDO: generando numero random
 * ADIVINANDO: adivinando el numero
 * @param start_activo: Boolean si el boton Start esta activo
 * @param boton_activo: Boolean si los botones de colores estan activos
 */
enum class Estados(val start_activo: Boolean, val boton_activo: Boolean) {
    INICIO(start_activo = true, boton_activo = false),
    GENERANDO(start_activo = false, boton_activo = false),
    ADIVINANDO(start_activo = false, boton_activo = true)
}