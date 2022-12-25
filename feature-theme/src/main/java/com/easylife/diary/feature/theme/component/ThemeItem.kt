package com.easylife.diary.feature.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.easylife.diary.core.designsystem.theme.black
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.feature.theme.util.Theme
import com.easylife.diary.feature.theme.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

/**
 * Created by erenalpaslan on 24.12.2022
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerScope.ThemeItem(
    theme: Theme,
    page: Int
) {
    Scaffold(
        containerColor = theme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                // Calculate the absolute offset for the current page from the
                // scroll position. We use the absolute value which allows us to mirror
                // any effects for both directions
                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                lerp(
                    start = 0.80f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    //scaleX = scale
                    scaleY = scale
                }
            }
            .clip(MaterialTheme.shapes.large),
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.extraSmall)
                            .background(theme.colorScheme.onSurfaceVariant)
                            .fillMaxWidth(0.45f)
                            .height(20.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = theme.colorScheme.background,
                ),
            )
        },

        bottomBar = {

        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            ExampleDiaryItem("07 MAR", "Sunday", showBackground = true, theme = theme)
            Spacer(modifier = Modifier.height(8.dp))
            ExampleDiaryItem("08 MAR", "Monday", theme = theme)
            Spacer(modifier = Modifier.height(8.dp))
            ExampleDiaryItem("08 MAR", "Monday", showTitle = false, theme = theme)
        }
    }
}

@Composable
fun ExampleDiaryItem(
    dayOfMonth: String,
    day: String,
    showBackground: Boolean = false,
    showTitle: Boolean = true,
    theme: Theme
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = theme.colorScheme.surfaceVariant)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        if (showBackground) {
            Image(
                painter = painterResource(id = R.drawable.bg_image_placeholder),
                contentDescription = "Background Placeholder",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(70.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = dayOfMonth,
                fontWeight = FontWeight.Bold,
                color = theme.colorScheme.onSurfaceVariant
            )
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(theme.colorScheme.onSurfaceVariant)
                    .size(6.dp)
            )
            Text(
                text = day,
                color = theme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (showTitle) {
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Box(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.extraSmall)
                        .background(theme.colorScheme.onSurfaceVariant)
                        .height(12.dp)
                        .fillMaxWidth(0.35f)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Box(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(theme.colorScheme.onSurfaceVariant)
                    .fillMaxWidth(0.9f)
                    .height(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Box(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(theme.colorScheme.onSurfaceVariant)
                    .fillMaxWidth(0.7f)
                    .height(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}