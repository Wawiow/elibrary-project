package com.example.elibraryproject.data.model

data class Document(
    val id: Int,
    val title: String,
    val abstract_id: String?,
    val year_published: Int?,
    val file_path: String?,
    val thumbnail_url: String?,
    val authors: List<Author> = emptyList()
)

data class Author(
    val first_name: String,
    val last_name: String
)

