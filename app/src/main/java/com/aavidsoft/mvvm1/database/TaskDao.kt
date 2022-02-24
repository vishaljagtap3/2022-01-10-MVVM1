package com.aavidsoft.mvvm1.database

import androidx.room.*
import com.aavidsoft.mvvm1.models.Task

@Dao
abstract class TaskDao {

    @Query("select * from tasks")
    abstract fun getTasks() : List<Task>

    @Insert
    abstract fun insertTask(task: Task)

    @Update
    abstract fun updateTask(task: Task)

    @Delete
    abstract fun deleteTask(task: Task)
}