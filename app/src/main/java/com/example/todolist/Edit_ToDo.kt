package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentEditToDoBinding
import com.example.todolist.model.ToDoViweModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class Edit_ToDo : Fragment() {
    private var binding: FragmentEditToDoBinding? = null
    private var indext: Int = 0
    var taskID = 0
    private var Time: String = ""
    private var smallTime: Long = 0

    private val sharedViewModel: ToDoViweModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditToDoBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            editTodo = this@Edit_ToDo
        }

        sharedViewModel.RasetTextView()

        arguments.let {
            taskID = it?.getInt("id", 0)!!
            indext = it.getInt("indext")
            smallTime = it.getLong("timeCompare")
            println("argument${it.getLong("timeCompare")}")

        }

        sharedViewModel.updateCurrentData(taskID)

    }


    fun EditNote() {

        sharedViewModel.EditTask(indext)

        findNavController().navigate(R.id.action_edit_ToDo_to_listOfToDo)
    }

    fun DeleteTask() {
        sharedViewModel.RemoveTask(indext)
        findNavController().navigate(R.id.action_edit_ToDo_to_listOfToDo)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun showDatePicker() {

        val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        datePicker.show(parentFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {
            smallTime = it
            Time = convertMillisecondsToReadableDate(it, "yyyy/MM/dd ")

            sharedViewModel.updateDate(Time)
            sharedViewModel.camperBetweenTime(smallTime)


        }

    }


    private fun convertMillisecondsToReadableDate(dateMilliseconds: Long, datePattern: String): String {
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))
    }

}


