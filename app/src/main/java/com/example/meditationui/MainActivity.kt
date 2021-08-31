package com.example.meditationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.meditationui.ui.HomeScreen
import com.example.meditationui.ui.theme.MeditationUIYouTubeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme() {
                HomeScreen()
            }
        }
    }
}
