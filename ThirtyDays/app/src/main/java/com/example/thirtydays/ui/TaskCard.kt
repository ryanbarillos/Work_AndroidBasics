package com.example.thirtydays.ui

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydays.model.Task



@Composable
fun TaskCardInfo(
    @StringRes info: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = info),
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(task: Task, day: Int, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val paddingImage = 8.dp
    val borderWidth = 4.dp

    Card(
        modifier = modifier,
        onClick = {
            expanded = !expanded
        }
    ) {
        Column (modifier = Modifier
            .padding(8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Text(
                text = "Day $day",
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = task.title),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Image(
                painter = painterResource(id = task.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(
                            width = borderWidth,
                            color = MaterialTheme.colorScheme.secondary),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(top = paddingImage, bottom = paddingImage),
            )
            if (expanded) {
                TaskCardInfo(
                    info = task.description
                )
            }
            Text(
                text = if(!expanded) "Read more..." else "\nShow less",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}