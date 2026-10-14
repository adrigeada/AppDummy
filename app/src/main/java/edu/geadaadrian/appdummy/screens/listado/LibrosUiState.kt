package edu.geadaadrian.appdummy.screens.listado

import edu.geadaadrian.appdummy.data.model.Libro

sealed class LibrosUiState {
    // data object (Kotlin 1.9+): genera toString() legible ("Cargando"
    // en lugar del hash de referencia). Usar siempre para estados sin datos.
    data object Cargando : LibrosUiState()
    data class Exito(val libros: List<Libro>) : LibrosUiState()
    data class Error(val mensaje: String) : LibrosUiState()
}