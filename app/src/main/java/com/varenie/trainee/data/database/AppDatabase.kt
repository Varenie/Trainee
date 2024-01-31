package com.varenie.trainee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.varenie.trainee.data.database.daos.WorkoutDao
import com.varenie.trainee.data.database.entities.WorkoutEntity

@Database(
    entities = [WorkoutEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun workoutDao(): WorkoutDao
}