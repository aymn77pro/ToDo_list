package com.example.todolist.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViweModel : ViewModel() {
    private val _title = MutableLiveData<String>("Title")
    val title:LiveData<String> = _title

    private val _subTitle = MutableLiveData<String>("subTitel")
    val subTitle : LiveData<String> =_subTitle

    private val _date = MutableLiveData<String>("Time")
    val date : LiveData<String> = _date
}

class DataList(val title: String, val subTitle:String, val date:String){}