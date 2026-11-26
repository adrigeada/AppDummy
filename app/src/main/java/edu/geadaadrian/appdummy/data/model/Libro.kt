package edu.geadaadrian.appdummy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "titulo")
    val titulo: String,

    @ColumnInfo(name = "autor")
    val autor: String,

    @ColumnInfo(name = "year")
    val year: Int? = 1900,

    @ColumnInfo(name = "isbn")
    val isbn: String,

    @ColumnInfo(name = "cover")
    val cover: String? = null,

    @ColumnInfo(name = "es_favorito")
    val esFavorito: Boolean = false,

    @ColumnInfo(name = "leido")
    val leido: Boolean = false
)
