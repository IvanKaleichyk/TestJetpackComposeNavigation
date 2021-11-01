package com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kaleichyk.testjetpackcomposenavigation.navigation.DiaryBottomNavBarDestination
import com.kaleichyk.testjetpackcomposenavigation.navigation.HomeBottomNavBarDestination
import com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.graphs.diaryGraph
import com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.graphs.homeNavGraph
import com.kaleichyk.testjetpackcomposenavigation.ui.theme.TestJetpackComposeNavigationTheme

@Composable
fun BottomNavBarScreen() {
    val navController = rememberNavController()
    val items = getNavBarItem()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { destination ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = destination.icon),
                                contentDescription = stringResource(
                                    id = destination.title
                                )
                            )
                        },
                        label = {
                            Text(stringResource(id = destination.title))
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == destination.toRoute() } == true,
                        onClick = {
                            navController.navigate(destination.toRoute()) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) {
        NavHost(navController, startDestination = HomeBottomNavBarDestination.toRoute()) {
            homeNavGraph()
            diaryGraph(navController)
        }
    }
}

fun getNavBarItem() =
    listOf(HomeBottomNavBarDestination, DiaryBottomNavBarDestination)

@Preview
@Composable
fun BottomNavBarScreenPreview() {
    TestJetpackComposeNavigationTheme {
        Surface(color = MaterialTheme.colors.background) {
            BottomNavBarScreen()
        }
    }
}