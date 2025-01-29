package com.example.recuperacinpmdm_estebanmontes.model

object Datos {
    val palabrasYPistas: Map<String, List<String>> = mapOf(
        "Calvo" to listOf("Alopécico", "Bola de billar", "Cabeza bombilla"),
        "Tatuaje" to listOf("Pintura en piel", "Delincuencia", "Sin futuro"),
        "Amigo" to listOf("Hermano de otra madre", "Mi bro", "Compañero"),
        "Colegio" to listOf("Carcel para niños", "Centro de 'educación'", "Pasas allí 18 años de tu vida"),
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
    ADIVINANDO(start_activo = false, boton_activo = true)
}