# RECUPERACIÓN PMDM
*Esteban Miguel Montes Adraz* - *2 DAM* - *PMDM*

## DESCRIPCIÓN
Desarrollar un juego para adivinar una palabra mediante una serie de pistas que se irám dando

## CÓMO JUGAR
Es un juego realmente sencillo:
1. Se inicia el juego y se muestra una pista.
2. Se introduce una palabra.
3. Si la palabra es correcta, se muestra un mensaje de felicitación y se finaliza el juego.
4. Si la palabra es incorrecta, se muestra la siguiente pista y se vuelve al paso 2.
5. Si se agotan los intentos, se muestra un mensaje de derrota y se finaliza el juego.

 ## Estructura del Proyecto

### Modelo de Datos
- **Datos**: Es un objeto que contiene la información sobre las palabras y sus pistas. Utiliza un `Map` de tipo `String` (la palabra) a `List<String>` (las pistas).
- Las palabras y pistas definidas son las siguientes:
  - **Calvo**: "Alopécico", "Bola de billar", "Cabeza bombilla".
  - **Tatuaje**: "Pintura en piel", "Delincuencia", "Sin futuro".
  - **Amigo**: "Hermano de otra madre", "Mi bro", "Compañero".
  - **Colegio**: "Carcel para niños", "Centro de 'educación'", "Pasas allí 18 años de tu vida".
  
- **Variables**:
  - `palabra`: Una palabra seleccionada aleatoriamente de las definidas en el mapa.
  - `pistas`: La lista de pistas asociadas a la palabra seleccionada.
  - `intentos`: El contador de intentos fallidos realizados por el jugador.

### Estados del Juego

La aplicación utiliza un `enum class` llamado **Estados** que define los dos estados principales del juego:
- **INICIO**: Estado en el que el juego está listo para empezar.
- **ADIVINANDO**: Estado en el que el jugador puede adivinar la palabra, mientras se muestran pistas.

## Interacción con el Usuario

1. El jugador inicia el juego presionando el botón **Comenzar**.
2. Se le muestra una pista aleatoria.
3. El jugador debe adivinar la palabra introduciendo su respuesta.
4. Después de cada intento incorrecto, se muestra una nueva pista.
5. Si el jugador acierta la palabra o se queda sin intentos, el juego se reinicia.

## Dependencias

- **Kotlin**: Lenguaje principal para la implementación.
- **Jetpack Compose**: Para la creación de la interfaz de usuario.
- **Android Lifecycle**: Para la gestión del ciclo de vida de la actividad y ViewModel.

