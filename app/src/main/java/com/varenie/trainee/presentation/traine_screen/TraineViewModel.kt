package com.varenie.trainee.presentation.traine_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varenie.trainee.data.database.AppDatabase
import com.varenie.trainee.data.database.entities.WorkoutEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TraineViewModel @Inject constructor(
    private val appDatabase: AppDatabase
): ViewModel() {

    fun addWorkout(name: String) {
        viewModelScope.launch {
            appDatabase.workoutDao().insertWorkout(
                WorkoutEntity(
                    0,
                    name
                )
            )
        }
    }
}