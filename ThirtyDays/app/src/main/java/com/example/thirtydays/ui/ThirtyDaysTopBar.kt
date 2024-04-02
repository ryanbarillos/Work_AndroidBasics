package com.example.thirtydays.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30-Day Challenge!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    )
}