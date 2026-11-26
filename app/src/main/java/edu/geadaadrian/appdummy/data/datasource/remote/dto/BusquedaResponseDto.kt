package edu.geadaadrian.appdummy.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class BusquedaResponseDto (
    @SerializedName("numFound")
    val numFound: Int? = null,

    @SerializedName("start")
    val start: Int? = null,

    @SerializedName("docs")
    val docs: List<LibroDto>? = null
)