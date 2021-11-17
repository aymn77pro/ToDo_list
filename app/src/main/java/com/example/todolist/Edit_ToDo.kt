package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.todolist.databinding.FragmentEditToDoBinding
import com.example.todolist.model.DataList
import com.example.todolist.model.ToDoViweModel


class Edit_ToDo : Fragment() {
    private var binding: FragmentEditToDoBinding? = null
    private var indext : Int? = 0
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
        arguments.let {
            indext=it?.getInt("indext")
            binding?.titleEdit?.setText(it?.getString("title"))
            binding?.subTitleEdit?.setText(it?.getString("subTitle"))
            binding?.timeEdit?.setText(it?.getString("date"))
            binding!!.completOrNot.isChecked=it!!.getBoolean("imported")
            binding!!.completOrNot.setOnCheckedChangeListener{context,isChecked ->
                if (isChecked)true else false
            }
        }

    }

    private fun saveEditValue(){
        val titleValue = binding?.titleEdit?.text.toString()
        val subTitleValue = binding?.subTitleEdit?.text.toString()
        val dataValue = binding?.timeEdit?.text.toString()
        val check = if (binding!!.completOrNot.isChecked)true else false
         sharedViewModel.EditTask(DataList(titleValue,subTitleValue,dataValue,check), indext!!)

    }

    fun EditNote() {
        saveEditValue()
       // val actionValue = Edit_ToDoDirections.actionEditToDoToListOfToDo(title = binding?.titleEdit?.text.toString()
         //   , binding?.subTitleEdit?.text.toString(),binding?.timeEdit?.text.toString(),
           // binding!!.completOrNot.isChecked, indext!!)
        view?.findNavController()?.navigate(R.id.action_edit_ToDo_to_listOfToDo)
    }

    fun TimeTask(){

    }

    fun DeleteTask(){
        sharedViewModel.RemoveTask(indext!!.toInt())
        view?.findNavController()?.navigate(R.id.action_edit_ToDo_to_listOfToDo)
    }

//    private fun onSaveValue(){
//       val title = sharedViewModel.title
//        val subTitle = sharedViewModel.subTitle
//        val data = sharedViewModel.date

//    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


