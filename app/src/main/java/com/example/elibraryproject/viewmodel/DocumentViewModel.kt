package com.example.elibraryproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elibraryproject.data.model.Document
import com.example.elibraryproject.data.repository.DocumentRepository
import kotlinx.coroutines.launch

class DocumentViewModel(private val repository: DocumentRepository) : ViewModel() {

    var documents by mutableStateOf<List<Document>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun fetchDocuments(query: String? = null) {
        viewModelScope.launch {
            isLoading = true
            try {
                documents = repository.getDocuments(query)
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}
