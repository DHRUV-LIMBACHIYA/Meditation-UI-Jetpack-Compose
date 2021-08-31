package com.example.meditationui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationui.R
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.DarkerButtonBlue
import com.example.meditationui.ui.theme.DeepBlue
import com.example.meditationui.ui.theme.TextWhite

/**
 * Created by Dhruv Limbachiya on 31-08-2021.
 */

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        GreetingSection(name = "Dhruv")
        ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Anxiety", "Stress"))
    }
}

@Composable
fun GreetingSection(
    name: String
) {
    Row(

        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            Modifier.size(24.dp),
            tint = TextWhite
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {

        items(chips.size) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable {
                        selectedIndex = it
                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        color = if (selectedIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = chips[it],
                    color = TextWhite,
                )
            }
        }
    }
}