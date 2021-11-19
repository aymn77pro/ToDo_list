package com.example.todolist.Date

import com.example.todolist.model.TaskData
import com.example.todolist.model.ToDoViweModel

class DateSource {
    val viewModel = ToDoViweModel()
    fun loadNote(): MutableList<TaskData> {
        return userBasrfTask
    }
}

var userBasrfTask: MutableList<TaskData> = mutableListOf()

