package com.aavidsoft.mvvm1.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "tasks")
data class Task(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id : Int,

    @NotNull
    @ColumnInfo(name = "title")
    var title : String,

    @ColumnInfo(name = "status")
    var status : Int,

    @ColumnInfo(name = "category")
    var category : String = "General"
)