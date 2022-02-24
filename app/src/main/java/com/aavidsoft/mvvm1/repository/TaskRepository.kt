package com.aavidsoft.mvvm1.repository

import com.aavidsoft.mvvm1.database.AppDatabase
import com.aavidsoft.mvvm1.models.Task

class TaskRepository(val appDb : AppDatabase) {

    fun getTasks() : List<Task> {
        return appDb.getTaskDao().getTasks()
    }

    fun insertTask(task: Task) {
        appDb.getTaskDao().insertTask(task)
    }
}