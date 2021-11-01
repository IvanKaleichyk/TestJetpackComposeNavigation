package com.kaleichyk.testjetpackcomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.kaleichyk.testjetpackcomposenavigation.ui.theme.TestJetpackComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestJetpackComposeNavigationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationApp()
                }
            }
        }
    }
}