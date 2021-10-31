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
import com.kaleichyk.testjetpackcomposenavigation.navigation.NoteDetailsDestination
import com.kaleichyk.testjetpackcomposenavigation.navigation.NotesDestination
import com.kaleichyk.testjetpackcomposenavigation.sreence.noteDetails.NoteDetailsScreen
import com.kaleichyk.testjetpackcomposenavigation.sreence.notes.NoteListScreen
import com.kaleichyk.testjetpackcomposenavigation.sreence.notes.NotesListNavigatorImpl

@ExperimentalCoilApi
@Composable
fun NavigationApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = NotesDestination.toRoute()) {
        composable(NotesDestination.toRoute()) {
            NoteListScreen(notes = notes, navigator = NotesListNavigatorImpl(navController))
        }
        composable(
            NoteDetailsDestination.toRoute(),
            arguments = listOf(navArgument(NoteDetailsDestination.key) { type = NavType.IntType })
        ) { stack ->
            stack.arguments?.getInt(NoteDetailsDestination.key)?.let { id ->
                NoteDetailsScreen(id = id)
            }
        }
    }
}