//package com.example.elibraryproject.data.api
//
//import com.example.elibraryproject.data.model.SearchResponse
//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Path
//import retrofit2.http.Query
//
//interface OpenLibraryApi {
//
//    @GET("search.json")
//    suspend fun searchBooks(
//        @Query("q") query: String
//    ): SearchResponse
//
//    @GET("api/documents/search")
//    fun searchDocuments(
//        @Query("q") query: String? = null
//    ): Call<DocumentListResponse>
//
//    @GET("api/documents/featured-content")
//    fun featuredDocuments(): Call<DocumentListResponse>
//
//    @GET("api/documents/{id}")
//    fun getDocumentDetail(
//        @Path("id") id: Int
//    ): Call<DocumentDetailResponse
//            >
//
//    @GET("api/filters")
//    fun getFilters(): Call<FilterResponse>
//
//
//}
