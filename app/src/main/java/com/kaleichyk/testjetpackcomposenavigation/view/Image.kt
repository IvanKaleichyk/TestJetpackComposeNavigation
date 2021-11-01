package com.kaleichyk.testjetpackcomposenavigation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun Avatar(avatarSrc : String){
    Image(
        painter = rememberImagePainter(avatarSrc),
        contentDescription = null,
        modifier = Modifier.size(32.dp)
    )
}