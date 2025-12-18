package com.example.elibraryproject.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.elibraryproject.ui.components.BookCard
import com.example.elibraryproject.viewmodel.BookViewModel

@Composable
fun KatalogScreen(
    navController: NavController,
    viewModel: BookViewModel
) {
    val books = viewModel.books
    val isLoading = viewModel.isLoading

    Column(Modifier.fillMaxSize()) {

        if (isLoading) {
            CircularProgressIndicator()
        }

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(books) { book ->
                BookCard(
                    book = book,
                    modifier = Modifier.clickable {
                        navController.navigate("detail/${book.id}")
                    }
                )
            }
        }

    }
}
