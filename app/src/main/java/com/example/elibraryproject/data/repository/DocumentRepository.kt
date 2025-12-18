package com.example.elibraryproject.data.repository

import com.example.elibraryproject.data.model.Document
import com.example.elibraryproject.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DocumentRepository(
    private val api: ApiService
) {

    suspend fun getDocuments(query: String? = null): List<Document> =
        withContext(Dispatchers.IO) {
            val response = api.searchDocuments(query)
            if (response.isSuccessful) {
                return@withContext response.body()?.data ?: emptyList<Document>()
            } else {
                return@withContext emptyList<Document>()
            }
        }

    suspend fun getDocumentById(id: Int): Document =
        withContext(Dispatchers.IO) {
            val response = api.getDocumentDetail(id)
            if (response.isSuccessful) {
                return@withContext response.body()!!.data
            } else {
                throw Exception("Gagal memuat detail dokumen")
            }
        }
}
