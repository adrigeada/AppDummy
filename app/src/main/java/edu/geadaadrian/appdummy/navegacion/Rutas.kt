package edu.geadaadrian.appdummy.navegacion
import kotlinx.serialization.Serializable

@Serializable data object Inicio
@Serializable data object Listado
@Serializable data class Detalle(val id: String)
@Serializable data object Favoritos

@Serializable data object Permisos