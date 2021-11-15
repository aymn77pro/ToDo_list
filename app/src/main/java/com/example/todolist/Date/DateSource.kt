package com.example.todolist.Date

import com.example.todolist.model.DataList
import com.example.todolist.model.ToDoViweModel

class DateSource {
    val viewModel = ToDoViweModel()
    fun loadNote():List<DataList> {
        return listOf<DataList>(
            DataList(viewModel.title.value.toString(),viewModel.subTitle.value.toString(),viewModel.date.value.toString())
        )
    }


}