package com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.graphs

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.kaleichyk.testjetpackcomposenavigation.data.notes
import com.kaleichyk.testjetpackcomposenavigation.navigation.DiaryBottomNavBarDestination
import com.kaleichyk.testjetpackcomposenavigation.navigation.NoteDetailsDestination
import com.kaleichyk.testjetpackcomposenavigation.navigation.NotesDestination
import com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.navItems.noteDetails.NoteDetailsScreen
import com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.navItems.notes.NoteListScreen
import com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.navItems.notes.NotesListNavigatorImpl

fun NavGraphBuilder.diaryGraph(navController: NavController) {
    navigation(
        startDestination = NotesDestination.toRoute(),
        route = DiaryBottomNavBarDestination.toRoute()
    ) {
        composable(NotesDestination.toRoute()) {
            NoteListScreen(notes = notes, navigator = NotesListNavigatorImpl(navController))
        }
        composable(
            NoteDetailsDestination.toRoute(),
            arguments = listOf(navArgument(NoteDetailsDestination.key) {
                type = NavType.IntType
            }),
            deepLinks = listOf(navDeepLink { uriPattern = NoteDetailsDestination.toDeepLink() })
        ) { stack ->
            stack.arguments?.getInt(NoteDetailsDestination.key)?.let { id ->
                NoteDetailsScreen(id = id)
            }
        }
    }
}