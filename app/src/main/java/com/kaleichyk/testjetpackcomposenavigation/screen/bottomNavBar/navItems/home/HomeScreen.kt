package com.kaleichyk.testjetpackcomposenavigation.screen.bottomNavBar.navItems.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(Modifier)
}