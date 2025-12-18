package com.example.elibraryproject.data.model

data class BookDoc(
    val id: Int,
    val title: String?,
    val author: String = "Unknown Author",
    val thumbnailUrl: String? = null,
    val filePath: String? = null
)

