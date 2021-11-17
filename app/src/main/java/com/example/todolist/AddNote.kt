package com.example.todolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentAddNoteBinding
import com.example.todolist.model.DataList
import com.example.todolist.model.ToDoViweModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class AddNote : BottomSheetDialogFragment() {

    private var _binding: FragmentAddNoteBinding? = null
    val binding get() = _binding
    val shearModelView :ToDoViweModel by activityViewModels()
    var Time:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding?.apply {
            viewModel = shearModelView
            lifecycleOwner = viewLifecycleOwner
            addNote = this@AddNote
        }

        binding?.addNewNote?.setOnClickListener {
            addNewNote()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun showDatePicker() {

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        datePicker.show(parentFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {

          Time =  convertMillisecondsToReadableDate(it, "EEE, MMM dd ")
            shearModelView.updateDate(Time)
            Toast.makeText(requireContext(),"$Time", Toast.LENGTH_LONG).show()

        }

    }

    private fun convertMillisecondsToReadableDate (dateMilliseconds: Long, datePattern: String): String{
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))
    }

    fun addNewNote(){
        val title = binding?.taskTitleTextField?.text
        val subTitle = binding?.taskDescriptionTextField?.text
        val data = Time
        shearModelView.addTask(DataList(title.toString(),subTitle.toString(),data,false))

        val actionAddNote = AddNoteDirections.actionAddNote2ToListOfToDo(title = title.toString(),subTitle = subTitle.toString(),data = data,false,indext = 0)
        findNavController().navigate(actionAddNote)
    }

}