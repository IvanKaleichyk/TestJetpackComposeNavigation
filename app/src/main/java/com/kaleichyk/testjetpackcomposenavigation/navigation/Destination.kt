package com.kaleichyk.testjetpackcomposenavigation.navigation

import com.kaleichyk.testjetpackcomposenavigation.App.Companion.URL

object NoteDetailsDestination : Parametrized<Int>("notes/details", "id", "$URL/notes")

object NotesDestination : Destination("notes")

sealed class Destination(
    protected open val route: String,
    protected open val deepLink: String? = null,
) {

    open fun toRoute() = route

    open fun toDeepLink() = deepLink
}

sealed class Parametrized<T>(
    override val route: String,
    val key: String,
    override val deepLink: String? = null
) : Destination(route) {

    override fun toRoute() = "$route/{$key}"

    override fun toDeepLink() = "$deepLink/{$key}"

    fun toRoute(param: T) = "$route/$param"

    fun toDeepLink(param: T) = "$deepLink/$param"
}