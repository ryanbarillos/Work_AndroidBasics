package com.example.thirtydays

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thirtydays.model.Task
import com.example.thirtydays.ui.TaskCard
import com.example.thirtydays.ui.ThirtyDaysTopBar

@Composable
fun ThirtyDaysApp(tasksList: List<Task>, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            ThirtyDaysTopBar()
        }
    ) { it ->
        LazyColumn (
            contentPadding = it,
            modifier = modifier
        ) {
            itemsIndexed(tasksList) { index, task ->
                TaskCard(
                    task = task,
                    day = index + 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }
        }
    }
}