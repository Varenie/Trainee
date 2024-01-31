package com.varenie.trainee.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "number_of_exercises")
    val numberOfExercises: Int = 0
)