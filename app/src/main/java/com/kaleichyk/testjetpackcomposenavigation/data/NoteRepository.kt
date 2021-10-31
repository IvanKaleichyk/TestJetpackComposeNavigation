package com.kaleichyk.testjetpackcomposenavigation.data

interface NoteRepository {

    suspend fun getNotes(): List<NoteModel>
}