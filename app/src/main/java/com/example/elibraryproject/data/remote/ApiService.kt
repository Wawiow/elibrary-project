package com.example.elibraryproject.data.remote

import com.example.elibraryproject.data.model.DocumentDetailResponse
import com.example.elibraryproject.data.model.DocumentListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("documents/featured-content")
    suspend fun getFeaturedDocuments(): Response<FeaturedResponse>

    @GET("documents/search")
    suspend fun searchDocuments(
        @Query("q") query: String? = null
    ): Response<DocumentListResponse>

    @GET("documents/{id}")
    suspend fun getDocumentDetail(
        @Path("id") id: Int
    ): Response<DocumentDetailResponse>
}

data class FeaturedResponse(
    val featured: List<DocumentItem>,
    val latest: List<DocumentItem>,
    val most_downloaded: List<DocumentItem>
)

data class DocumentItem(
    val id: Int,
    val title: String?,
    val thumbnail_url: String?,
    val authors: List<AuthorItem>?
)

data class AuthorItem(
    val first_name: String,
    val last_name: String?
)
