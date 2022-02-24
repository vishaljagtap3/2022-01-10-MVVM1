package com.aavidsoft.mvvm1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.aavidsoft.mvvm1.application.MyApplication
import com.aavidsoft.mvvm1.database.AppDatabase
import com.aavidsoft.mvvm1.models.Task

class MainActivity : AppCompatActivity() {

    lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDb = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "db_tasks"
        ).build()

        setContentView(R.layout.activity_main)



    }

    private fun mt(text : String) {
        Log.e("tag", text)
    }
}