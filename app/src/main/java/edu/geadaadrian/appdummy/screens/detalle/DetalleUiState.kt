package edu.geadaadrian.appdummy.screens.detalle

import edu.geadaadrian.appdummy.data.model.Libro

sealed class DetalleUiState {
    data object Cargando : DetalleUiState()
    data class Exito(val libro: Libro) : DetalleUiState()
    data object NoEncontrado : DetalleUiState()
}