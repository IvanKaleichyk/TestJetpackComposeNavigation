package com.kaleichyk.testjetpackcomposenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.kaleichyk.testjetpackcomposenavigation.data.notes

@ExperimentalCoilApi
@Composable
fun NavigationApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "notes") {
        composable("notes") {
            NoteListScreen(notes = notes, navController = navController)
        }
        composable(
            "notes/details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { stack ->
            stack.arguments?.getInt("id")?.let { id ->
                NoteDetailsScreen(id = id)
            }
        }
    }
}