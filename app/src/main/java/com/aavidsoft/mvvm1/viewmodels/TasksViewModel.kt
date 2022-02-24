package com.aavidsoft.mvvm1.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aavidsoft.mvvm1.models.Task
import com.aavidsoft.mvvm1.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TasksViewModel(var taskRepository: TaskRepository) : ViewModel(){

    var tasksList = ArrayList<Task>()

    var dataAvailableLiveData = MutableLiveData<Boolean>()

    fun getTasks() {
        CoroutineScope(Dispatchers.IO).launch {

            taskRepository.insertTask(
                Task(
                    0,
                    "Demo title",
                    1,
                    "Office"
                )
            )

            var tasks = taskRepository.getTasks()
            tasksList.addAll(tasks)

            withContext(Dispatchers.Main) {
                dataAvailableLiveData.postValue(true)
            }
        }



    }


}