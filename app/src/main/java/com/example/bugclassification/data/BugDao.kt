package com.example.bugclassification.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BugInfoDao {
    @Insert
    suspend fun insertBugInfo(bug: Bug)

    @Query("SELECT * FROM bug_info WHERE bugType = :bugType")
    suspend fun getBugInfoByType(bugType: String): Bug?
}

@Dao
interface InferenceInfoDao {
    @Insert
    suspend fun insertInferenceInfo(inference: Inference)

    @Query("SELECT * FROM inference_info WHERE bug_type = :bugType")
    suspend fun getInferenceInfoByBugType(bugType: String): Inference?
}
