package com.example.thirtydays.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydays.model.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(task: Task, day: Int, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val paddingImage = 8.dp
    Card(
        modifier = modifier,
        onClick = {
            expanded = !expanded
        }
    ) {
        Column (modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Day $day",
                fontSize = 20.sp
            )
            Text(
                text = stringResource(id = task.header),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Image(
                painter = painterResource(id = task.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(top = paddingImage, bottom = paddingImage),
                contentScale = ContentScale.Crop,
            )
            if (expanded) {
                Text(
                    text = stringResource(id = task.body),
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodyLarge
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