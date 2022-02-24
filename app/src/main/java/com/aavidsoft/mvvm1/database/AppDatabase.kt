package com.aavidsoft.mvvm1.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aavidsoft.mvvm1.models.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTaskDao() : TaskDao

}