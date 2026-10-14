package edu.geadaadrian.appdummy.data.repository

import edu.geadaadrian.appdummy.data.model.Libro
import kotlin.time.Duration.Companion.milliseconds

// En B3 este repositorio coordinará ROOM y Retrofit2.
// Por ahora usa datos estáticos para centrar el aprendizaje en la arquitectura.
class LibrosRepository {

    private val libros = listOf(
        Libro(
            1,
            "Proyecto Hail Mary",
            "Andy Weir",
            2021,
            "9788418037016",
            "https://covers.openlibrary.org/b/isbn/9788418037016-L.jpg",
            true,
            false
        ),
        Libro(2, "Juego de tronos", "George R.R. Martin", 1996, "9780307951182", "https://covers.openlibrary.org/b/isbn/9780307951182-L.jpg", true, true),
        Libro(3, "Festín de cuervos", "George R.R. Martin", 2005, "9780307951212", "https://covers.openlibrary.org/b/isbn/9780307951212-L.jpg", false, false),
        Libro(4, "Cementerio de Animales", "Stephen King", 1983, "9788401499845", "https://covers.openlibrary.org/b/isbn/9788401499845-L.jpg", false, true),
        Libro(5, "El juego de Ender", "Orson Scott Card", 1985, "9788498720068", "https://covers.openlibrary.org/b/isbn/9788498720068-L.jpg", false, true)
    )

    // suspend: puede suspenderse sin bloquear el hilo principal
    suspend fun getLibros(): List<Libro> {
        kotlinx.coroutines.delay(800.milliseconds)   // simula latencia de red
        return libros
    }

    suspend fun getAutores(): List<String> {
        kotlinx.coroutines.delay(300.milliseconds)
        return libros.map { it.autor }.distinct().sorted()
    }

    suspend fun getLibroPorId(id: Int): Libro? {
        kotlinx.coroutines.delay(300.milliseconds)
        return libros.find { it.id == id }
    }
}