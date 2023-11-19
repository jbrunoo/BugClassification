package com.example.bugclassification.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Bug::class, Inference::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bugInfoDao(): BugInfoDao
    abstract fun inferenceInfoDao(): InferenceInfoDao

    private class DatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.bugInfoDao())
                }
            }
        }

        suspend fun populateDatabase(bugInfoDao: BugInfoDao) {
            // 초기 데이터 추가
            for(bugInfo in BugInfo.values()) {
                val bug = Bug(
                    bugInfo.type,
                    bugInfo.title,
                    bugInfo.information,
                    bugInfo.habitat,
                    bugInfo.prevention,
                    bugInfo.extermination,
                )
                bugInfoDao.insertBugInfo(bug)
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bug.db"
                )
                    .addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}