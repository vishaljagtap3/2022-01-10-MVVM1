package com.aavidsoft.mvvm1.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aavidsoft.mvvm1.repository.TaskRepository
import com.aavidsoft.mvvm1.viewmodels.TasksViewModel
import java.lang.Error

class MyViewModelFactory(val taskRepository: TaskRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TasksViewModel::class.java)) {
            return TasksViewModel(taskRepository) as T
        }

        throw Error("Unable to instantiate ViewModel")
    }
}