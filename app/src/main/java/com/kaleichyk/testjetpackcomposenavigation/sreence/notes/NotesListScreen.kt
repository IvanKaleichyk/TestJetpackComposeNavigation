package com.kaleichyk.testjetpackcomposenavigation.sreence.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.kaleichyk.testjetpackcomposenavigation.data.NoteModel
import com.kaleichyk.testjetpackcomposenavigation.data.notes
import com.kaleichyk.testjetpackcomposenavigation.ui.theme.TestJetpackComposeNavigationTheme
import com.kaleichyk.testjetpackcomposenavigation.view.Avatar

@ExperimentalCoilApi
@Composable
fun NoteListScreen(
    navigator: NotesListNavigator?,
    modifier: Modifier = Modifier,
    notes: List<NoteModel>
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(
            items = notes,
            itemContent = {
                NoteViewHolder(note = it) {
                    navigator?.moveToNoteDetails(it.id)
                }
            }
        )
    }
}

@ExperimentalCoilApi
@Composable
inline fun NoteViewHolder(
    modifier: Modifier = Modifier,
    note: NoteModel,
    crossinline onTap: () -> Unit
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable { onTap.invoke() }) {
        Avatar(note.avatar)
        NoteDetails(note)
    }
}

@Composable
fun NoteDetails(note: NoteModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = note.author,
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = note.content,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun NoteListScreenPreview() {
    TestJetpackComposeNavigationTheme {
        Scaffold {
            NoteListScreen(notes = notes, navigator = null)
        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun NoteViewHolderPreview() {
    NoteViewHolder(note = notes[0]) {}
}