package com.example.thirtydays.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydays.model.Task

@Composable
fun CardOfDay(task: Task, modifier: Modifier = Modifier) {
    val num = 1
    Card(modifier = modifier) {
        Column (modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Day $num",
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
                modifier = Modifier.fillMaxWidth().height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = task.body),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}