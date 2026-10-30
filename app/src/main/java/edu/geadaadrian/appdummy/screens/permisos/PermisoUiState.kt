package edu.geadaadrian.appdummy.screens.permisos

sealed class PermisoUiState {
    data object Concedido : PermisoUiState()
    data object Pendiente : PermisoUiState()
    data object Denegado : PermisoUiState()
    data object DenegadoPermanentemente : PermisoUiState()
}
