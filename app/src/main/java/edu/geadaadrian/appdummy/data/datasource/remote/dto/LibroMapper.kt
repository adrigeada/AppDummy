package edu.geadaadrian.appdummy.data.datasource.remote.dto

import edu.geadaadrian.appdummy.data.datasource.remote.OpenLibrary
import edu.geadaadrian.appdummy.data.model.Libro

fun LibroDto.toLibro(isbnBuscado: String? = null): Libro? {

    val idObra = key ?: return null
    val tituloObra = title?.takeIf { it.isNotBlank() } ?: return null

    val isbn13 = isbnBuscado
        ?: isbn?.firstOrNull{it.length == 13}
        ?: isbn?.firstOrNull()
        ?: ""


    return Libro(
        id = idObra,
        titulo = tituloObra,
        autor = authorName
            ?.filter { it.isNotBlank() }
            ?.joinToString(", ")
            ?.takeIf { it.isNotBlank() }
            ?: "Autor desconocido",
        year = firstPublishYear,
        isbn = isbn13,

        cover = OpenLibrary.urlCaratulaPorId(coverId)
            ?: OpenLibrary.urlCaratulaPorIsbn(isbn13)
    )
}

// mapNotNull aplica toLibro() a cada documento y descarta automáticamente
// los que han devuelto null, sin necesidad de un filter previo
fun List<LibroDto>.toLibros(): List<Libro> = mapNotNull { it.toLibro() }