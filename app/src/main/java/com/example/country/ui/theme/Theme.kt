package com.example.country.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Thème clair
private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    background = Color(0xFFF6F6F6),
    onBackground = Color.Black
)

// Thème sombre
private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White
)

@Composable
fun CountryTheme(content: @Composable () -> Unit) {
    val isDarkMode = isSystemInDarkTheme()
    MaterialTheme(
        colorScheme = if (isDarkMode) DarkColors else LightColors,
        typography = Typography(),
        content = content
    )
}
