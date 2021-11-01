package com.kaleichyk.testjetpackcomposenavigation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kaleichyk.testjetpackcomposenavigation.App.Companion.URL
import com.kaleichyk.testjetpackcomposenavigation.R

object NoteDetailsDestination : Parametrized<Int>("notes/details", "id", "$URL/notes")

object NotesDestination : Destination("notes")

object HomeDestination : Destination("home")

object HomeBottomNavBarDestination :
    BottomNavBarDestination("homeNavBar", R.drawable.ic_home, R.string.home)

object DiaryBottomNavBarDestination :
    BottomNavBarDestination("diary", R.drawable.ic_diary, R.string.diary)

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

sealed class BottomNavBarDestination(
    override val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) : Destination(route)