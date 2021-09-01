package com.example.meditationui.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintSet
import com.example.meditationui.R
import com.example.meditationui.data.BottomMenuItem
import com.example.meditationui.data.Feature
import com.example.meditationui.data.features
import com.example.meditationui.standQuadFromTo
import com.example.meditationui.ui.theme.*

/**
 * Created by Dhruv Limbachiya on 31-08-2021.
 */

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection(name = "Dhruv")
            ChipSection(
                chips = listOf(
                    "Sweet Sleep",
                    "Insomnia",
                    "Depression",
                    "Anxiety",
                    "Stress"
                )
            )
            CurrentMeditation()
            FeaturedSection(features = features)
        }

        BottomMenu(
            bottomMenus = listOf(
                BottomMenuItem("Home", R.drawable.ic_home),
                BottomMenuItem("Meditate", R.drawable.ic_bubble),
                BottomMenuItem("Sleep", R.drawable.ic_moon),
                BottomMenuItem("Music", R.drawable.ic_music),
                BottomMenuItem("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun GreetingSection(name: String) {
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
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {

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
                    style = MaterialTheme.typography.h4
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
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun FeaturedSection(features: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = "Featured",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(feature.darkColor)
    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, -height * 0.02f)
        val mediumColoredPoint4 = Offset(width * 0.6f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())


        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standQuadFromTo(lightPoint1, lightPoint2)
            standQuadFromTo(lightPoint2, lightPoint3)
            standQuadFromTo(lightPoint3, lightPoint4)
            standQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 20.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                fontSize = 14.sp,
                color = TextWhite,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clickable {
                        /* NO OP */
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(12.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 16.dp)

            )
        }
    }
}

@Composable
fun BottomMenu(
    bottomMenus: List<BottomMenuItem>,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = TextWhite,
    inActiveTextColor: Color = AquaBlue,
    initialSelectedIndex: Int = 0,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(top = 10.dp, bottom = 10.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        var selectedIndex by remember {
            mutableStateOf(initialSelectedIndex)
        }

        bottomMenus.forEachIndexed { index, bottomMenuItem ->
            BottomMenuItem(
                bottomMenuItem = bottomMenuItem,
                isSelected = index == selectedIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inActiveTextColor = inActiveTextColor,
            ) {
                selectedIndex = index
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    bottomMenuItem: BottomMenuItem,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = TextWhite,
    inActiveTextColor: Color = AquaBlue,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable {
                onItemClick()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(14.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
        ) {
            Icon(
                painter = painterResource(id = bottomMenuItem.iconId),
                contentDescription = bottomMenuItem.title,
                tint = if (isSelected) Color.White else AquaBlue,
                modifier = Modifier
                    .padding(10.dp)
                    .size(24.dp)
            )
        }

        Text(
            text = bottomMenuItem.title,
            modifier = Modifier.padding(top = 4.dp),
            color = if (isSelected) activeTextColor else inActiveTextColor,
        )
    }
}