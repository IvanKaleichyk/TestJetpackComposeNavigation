package com.kaleichyk.testjetpackcomposenavigation.sreence.notes

import androidx.navigation.NavController
import com.kaleichyk.testjetpackcomposenavigation.navigation.NoteDetailsDestination

class NotesListNavigatorImpl(private val navController: NavController) : NotesListNavigator {

    override fun moveToNoteDetails(id: Int) {
        navController.navigate(NoteDetailsDestination.toRoute(id))
    }
}