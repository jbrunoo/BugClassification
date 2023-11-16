package com.example.bugclassification.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


interface BugDao {
    @Query("SELECT * FROM bug")
    fun getAll(): List<Bug>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Bug>

    @Query("SELECT * FROM bug WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Bug

    @Insert
    fun insertAll(vararg bugs: Bug)

    @Delete
    fun delete(user: Bug)
}