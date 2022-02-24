package com.aavidsoft.mvvm1.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aavidsoft.mvvm1.R
import com.aavidsoft.mvvm1.databinding.TaskViewBinding
import com.aavidsoft.mvvm1.models.Task

class TasksAdapter(var taskList : List<Task>) : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var binding : TaskViewBinding = TaskViewBinding.bind(itemView)
    }

    override fun getItemCount(): Int {
        return taskList.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            View.inflate(
                parent.context,
                R.layout.task_view,
                null
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.task = taskList[position]
    }
}