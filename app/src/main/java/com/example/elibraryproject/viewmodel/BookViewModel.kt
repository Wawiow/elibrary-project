package com.example.elibraryproject.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elibraryproject.data.model.BookDoc
import com.example.elibraryproject.data.repository.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(
    private val repository: BookRepository
) : ViewModel() {

    var books by mutableStateOf<List<BookDoc>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun loadFeaturedDocuments() {
        isLoading = true
        viewModelScope.launch {
            try {
                books = repository.getFeaturedDocuments()
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = "Gagal memuat data: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun search(query: String) {
        isLoading = true
        viewModelScope.launch {
            try {
                books = repository.searchDocuments(query)
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = "Gagal mencari buku"
            } finally {
                isLoading = false
            }
        }
    }


    fun getBookById(id: Int): BookDoc? {
        return books.find { it.id == id }
    }
}

