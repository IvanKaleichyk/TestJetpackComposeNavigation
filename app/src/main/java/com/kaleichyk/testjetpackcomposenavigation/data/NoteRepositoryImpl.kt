package com.kaleichyk.testjetpackcomposenavigation.data

val notes = listOf(
    NoteModel(
        0,
        "Ivan",
        "Test Note 1",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAkXqk6O9BTzcwCFV-kONJWEDg2mVGJ0lvlQ&usqp=CAU"
    ),
    NoteModel(
        1,
        "Mark",
        "Test Note 2",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7pmhmGk5QDqFEfSonO1YefwwlGoydauu0-A&usqp=CAU"
    )
)

class NoteRepositoryImpl : NoteRepository {

    override suspend fun getNotes() = notes
}