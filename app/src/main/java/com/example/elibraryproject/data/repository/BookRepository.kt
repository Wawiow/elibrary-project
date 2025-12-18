package com.example.elibraryproject.data.repository

import com.example.elibraryproject.data.model.BookDoc
import com.example.elibraryproject.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository(
    private val apiService: ApiService
) {

    suspend fun getFeaturedDocuments(): List<BookDoc> = withContext(Dispatchers.IO) {
        val response = apiService.getFeaturedDocuments()
        if (response.isSuccessful) {
            response.body()?.featured?.map { doc ->
                BookDoc(
                    id = doc.id,
                    title = doc.title,
                    author = doc.authors?.joinToString(", ") {
                        "${it.first_name} ${it.last_name ?: ""}"
                    } ?: "Unknown Author",
                    thumbnailUrl = doc.thumbnail_url,
                    filePath = null
                )
            } ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun searchDocuments(query: String): List<BookDoc> =
        withContext(Dispatchers.IO) {
            val response = apiService.searchDocuments(query)
            if (response.isSuccessful) {
                response.body()?.data?.map { doc ->
                    BookDoc(
                        id = doc.id,
                        title = doc.title,
                        author = doc.authors?.joinToString(", ") {
                            "${it.first_name} ${it.last_name ?: ""}"
                        } ?: "Unknown Author",
                        thumbnailUrl = doc.thumbnail_url,
                        filePath = null
                    )
                } ?: emptyList()
            } else {
                emptyList()
            }
        }
}
