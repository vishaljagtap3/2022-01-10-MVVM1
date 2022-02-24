package com.aavidsoft.mvvm1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aavidsoft.mvvm1.MainActivity
import com.aavidsoft.mvvm1.adapters.TasksAdapter
import com.aavidsoft.mvvm1.application.MyApplication
import com.aavidsoft.mvvm1.databinding.TaskListFragmentBinding
import com.aavidsoft.mvvm1.models.Task
import com.aavidsoft.mvvm1.repository.TaskRepository
import com.aavidsoft.mvvm1.viewmodels.TasksViewModel
import com.aavidsoft.mvvm1.viewmodels.factory.MyViewModelFactory

class TaskListFragment : Fragment() {

    private lateinit var binding : TaskListFragmentBinding
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var tasksViewModel: TasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //tasksViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        initViewModels()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TaskListFragmentBinding.inflate(inflater)

        initAdapterAndRecyclerView()
        initObservers()

        tasksViewModel.getTasks()

        return binding.root
    }


    private fun initObservers() {
        /*tasksViewModel.dataAvailableLiveData.observe(
            viewLifecycleOwner,
            DataUpdatesObserver()
        )*/
        tasksViewModel.dataAvailableLiveData.observe(
            viewLifecycleOwner
        ){
            if(it == true) {
                tasksAdapter.notifyDataSetChanged()
            }
        }
    }

    inner class DataUpdatesObserver : Observer<Boolean> {
        override fun onChanged(t: Boolean?) {
            if(t == true) {
                tasksAdapter.notifyDataSetChanged()
            }
        }
    }
    private fun initAdapterAndRecyclerView() {
        tasksAdapter = TasksAdapter(tasksViewModel.tasksList)

        binding.recyclerTasks.adapter = tasksAdapter
        binding.recyclerTasks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }


    private fun initViewModels() {
        tasksViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(
                TaskRepository(
                    (requireActivity() as MainActivity).appDb
                )
            )
        ).get(TasksViewModel::class.java)
    }
}