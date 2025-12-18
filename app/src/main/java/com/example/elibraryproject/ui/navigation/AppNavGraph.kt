package com.example.elibraryproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.elibraryproject.ui.screens.DetailScreen
import com.example.elibraryproject.ui.screens.KatalogScreen
import com.example.elibraryproject.ui.screens.LandingScreen
import com.example.elibraryproject.viewmodel.BookViewModel
import com.example.yourapp.ui.screens.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: BookViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") {
            HomeScreen(viewModel)
        }

        composable("katalog") {
            KatalogScreen(navController, viewModel)
        }

        composable(
            route = "detail/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId") ?: -1
            DetailScreen(navController, bookId, viewModel)
        }
    }
}
