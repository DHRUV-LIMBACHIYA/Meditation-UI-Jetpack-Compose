package com.example.meditationui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path

/**
 * Created by Dhruv Limbachiya on 01-09-2021.
 */

fun Path.standQuadFromTo(from: Offset,to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        kotlin.math.abs(from.x + to.x) / 2f,
        kotlin.math.abs(from.y + to.y) / 2f
    )
}