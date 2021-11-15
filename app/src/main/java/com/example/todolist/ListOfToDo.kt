package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.todolist.adapter.ListAdapter
import com.example.todolist.databinding.FragmentListOfToDoBinding

class ListOfToDo : Fragment() {
   private var _binding :FragmentListOfToDoBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListOfToDoBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.recycleN?.adapter = ListAdapter(context)
        binding?.recycleN?.setHasFixedSize(true)
        binding?.addNote?.setOnClickListener{
            var action = ListOfToDoDirections.actionListOfToDoToEditToDo()
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}