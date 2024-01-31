package com.varenie.trainee.presentation.traine_screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TraineeScreen() {
    Scaffold(
        topBar = {
                 TopAppBar(title = { Text(text = "Trainee") })
        },
        content = { paddingValues ->
            val t = paddingValues
        }
    )
}

@Preview
@Composable
private fun TraineeScreenPreview() {
    TraineeScreen()
}