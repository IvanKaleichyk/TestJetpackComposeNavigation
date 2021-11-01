package com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.navItems.noteDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaleichyk.testjetpackcomposenavigation.data.notes
import com.kaleichyk.testjetpackcomposenavigation.ui.theme.TestJetpackComposeNavigationTheme
import com.kaleichyk.testjetpackcomposenavigation.view.Avatar

@Composable
fun NoteDetailsScreen(id: Int, modifier: Modifier = Modifier) {
    val note = getNoteById(id)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar(note.avatar)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = note.author,
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = note.content,
        )
    }
}

private fun getNoteById(id: Int) = notes.find { it.id == id } ?: notes[0]

@Preview
@Composable
fun NoteDetailsScreenPreview() {
    TestJetpackComposeNavigationTheme {
        Scaffold {
            NoteDetailsScreen(notes[0].id)
        }
    }
}
