package com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kaleichyk.testjetpackcomposenavigation.navigation.HomeBottomNavBarDestination
import com.kaleichyk.testjetpackcomposenavigation.navigation.HomeDestination
import com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.navItems.home.HomeScreen

fun NavGraphBuilder.homeNavGraph() {
    navigation(
        startDestination = HomeDestination.toRoute(),
        route = HomeBottomNavBarDestination.toRoute()
    ) {
        composable(HomeDestination.toRoute()) {
            HomeScreen()
        }
    }
}