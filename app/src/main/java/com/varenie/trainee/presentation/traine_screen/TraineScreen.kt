package com.varenie.trainee.presentation.traine_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.varenie.trainee.R
import com.varenie.trainee.presentation.theme.BlurWhite
import com.varenie.trainee.presentation.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TraineeScreen(
    viewModel: TraineViewModel
) {
    val isShowDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
             TopAppBar(
                 title = {
                     Text(text = stringResource(id = R.string.workouts_title))
                 },
                 actions = {
                     IconButton(onClick = { /*TODO*/ }) {
                         Icon(
                             imageVector = Icons.Filled.AccountCircle,
                             contentDescription = null
                         )
                     }
                 }
             )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isShowDialog.value = true},
            ){
                Icon(Icons.Filled.Add,null)
            }
        },
        content = { paddingValues ->
            MainSection(paddingValues = paddingValues)
        }
    )

    if (isShowDialog.value) {
        WorkoutDialog(
            isShowDialog = isShowDialog,
            viewModel
        )
    }
}

@Composable
private fun MainSection(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        LazyColumn {
            items(10) {
                WorkoutListItem()
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
private fun WorkoutListItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Purple80,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Тренировка")
        Text(text = "12")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WorkoutDialog(
    isShowDialog: MutableState<Boolean>,
    viewModel: TraineViewModel
) {
    AlertDialog(
        onDismissRequest = { isShowDialog.value = false },
        modifier = Modifier
            .background(
                color = BlurWhite,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            var workoutName by remember { mutableStateOf("") }
            TextField(
                value = workoutName,
                onValueChange = { workoutName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                singleLine = true,

            )

            Button(
                onClick = { viewModel.addWorkout(workoutName) },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.create_btn_title))
            }
        }
    }
}

@Preview
@Composable
private fun DialogPreview() {
    val isShowDialog = remember {
        mutableStateOf(true)
    }

    WorkoutDialog(
        isShowDialog = isShowDialog,
        hiltViewModel()
    )
}

@Preview
@Composable
private fun TraineeScreenPreview() {
    TraineeScreen(hiltViewModel())
}