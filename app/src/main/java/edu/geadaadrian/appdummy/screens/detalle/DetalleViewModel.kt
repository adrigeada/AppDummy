package edu.geadaadrian.appdummy.screens.detalle

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import coil3.decode.StaticImageDecoder
import edu.geadaadrian.appdummy.data.repository.LibrosRepository
import edu.geadaadrian.appdummy.navegacion.Detalle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetalleViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: LibrosRepository,
) : ViewModel() {

    private val libroId: Int = savedStateHandle.toRoute<Detalle>().id
    private val _uiState = MutableStateFlow<DetalleUiState>(DetalleUiState.Cargando)
    val uiState: StateFlow<DetalleUiState> = _uiState.asStateFlow()


    init {
        cargarDetalle()
    }

    private fun cargarDetalle() {
        viewModelScope.launch {
            val libro = repository.getLibroPorId(libroId)
            _uiState.value = if (libro != null) DetalleUiState.Exito(libro)
            else DetalleUiState.NoEncontrado
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                DetalleViewModel(
                    savedStateHandle = createSavedStateHandle(),
                    repository = LibrosRepository()
                )
            }
        }
    }
}