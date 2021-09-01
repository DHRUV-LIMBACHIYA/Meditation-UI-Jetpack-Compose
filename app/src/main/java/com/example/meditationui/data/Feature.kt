package com.example.meditationui.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.meditationui.R
import com.example.meditationui.ui.theme.*

/**
 * Created by Dhruv Limbachiya on 01-09-2021.
 */

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)


val features = listOf(
    Feature(
        title = "Sleep meditation",
        R.drawable.ic_headphone,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        title = "Tips for sleeping",
        R.drawable.ic_videocam,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        title = "Night island",
        R.drawable.ic_headphone,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        title = "Calming sounds",
        R.drawable.ic_headphone,
        Beige1,
        Beige2,
        Beige3
    )
)