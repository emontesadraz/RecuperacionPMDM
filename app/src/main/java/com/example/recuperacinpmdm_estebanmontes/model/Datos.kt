package com.example.recuperacinpmdm_estebanmontes.model

data class Datos (
    val palabra: String,
    val pista: String,
    val intentos: Int,
    val rondas: Int
)

/**
 * Listas de las palabras a adivinar junto a sus pistas
 */
 val palabraAdivinar = mapOf(
     "amigo" to listOf("compañero", "hermano de otra madre","Tu bro"),
     "calvo" to listOf("alopecia","cabeza bombilla","bola de billar"),
     "tatuaje" to listOf("tinta en piel","sin futuro","delincuente"),
     "colegio" to listOf("carcel para niños", "sitio de 'educación'","estás allí 18 años de tu vida")
 )

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