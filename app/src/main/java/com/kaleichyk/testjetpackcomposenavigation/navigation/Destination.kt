package com.kaleichyk.testjetpackcomposenavigation.navigation

object NoteDetailsDestination : Parametrized<Int>("notes/details", "id")

object NotesDestination : Destination("notes")

sealed class Destination(protected open val route: String) {

    open fun toRoute() = route
}

sealed class Parametrized<T>(
    override val route: String,
    val key: String,
) : Destination(route) {

    override fun toRoute() = "$route/{$key}"

    fun toRoute(param: T) = "$route/$param"
}