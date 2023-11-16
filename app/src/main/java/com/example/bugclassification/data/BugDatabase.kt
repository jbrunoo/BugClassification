package com.example.bugclassification.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Bug::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bugDao(): BugDao
}