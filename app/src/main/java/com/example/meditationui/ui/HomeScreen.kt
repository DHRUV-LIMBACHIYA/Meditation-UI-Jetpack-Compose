package com.example.meditationui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.R
import com.example.meditationui.ui.theme.*

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
        CurrentMeditation()
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
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold
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
            Card(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable {
                        selectedIndex = it
                    },
                shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)),
                backgroundColor = if (selectedIndex == it) ButtonBlue else DarkerButtonBlue,
                elevation = 4.dp
            ) {
                Text(
                    text = chips[it],
                    color = TextWhite,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
fun CurrentMeditation() {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)),
        backgroundColor = LightRed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(
                vertical = 30.dp,
                horizontal = 20.dp
            )
        ) {
            Column {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.h1
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Meditation • 3-10 min",
                    style = MaterialTheme.typography.body1
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = TextWhite,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

