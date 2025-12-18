package com.example.yourapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.elibraryproject.ui.components.BookCard
import com.example.elibraryproject.viewmodel.BookViewModel

@Composable
fun HomeScreen(
    viewModel: BookViewModel
) {
    val books = viewModel.books
    val isLoading = viewModel.isLoading

    Column(Modifier.fillMaxSize()) {

        // Search
        TextField(
            value = "",
            onValueChange = { query ->
                viewModel.search(query)
            }
        )

        if (isLoading) {
            CircularProgressIndicator()
            return@Column
        }

        LazyColumn {
            items(books) { book ->
                BookCard(book)
            }
        }
    }
}

