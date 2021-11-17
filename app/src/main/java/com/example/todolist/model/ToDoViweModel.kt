package com.example.todolist.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.Date.userBasrfList


class DataList(var title: String?="", var subTitle: String?="", var date: String?="",var importing:Boolean)

class ToDoViweModel : ViewModel() {
    //val dateTask = EndOfTimeTask()
    private val _title = MutableLiveData<String>()
    val title:LiveData<String>  =  _title

        private val _subTitle = MutableLiveData<String>()
    val subTitle : LiveData<String>  =  _subTitle

     private val _date = MutableLiveData<String>()
    val date : MutableLiveData<String>  =  _date

    private val _comblet = MutableLiveData<Boolean>()
    val  comblet:LiveData<Boolean> = _comblet

    fun addTask(newTask: DataList) {
        userBasrfList.add(newTask)
    }
    fun EditTask(editTask:DataList,indext:Int){
        userBasrfList.set(indext,editTask)
    }
    fun RemoveTask(indext: Int){
        userBasrfList.removeAt(indext)
    }
//    private fun EndOfTimeTask(): MutableList<String> {
//        val options = mutableListOf<String>()
//        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
//        val calendar = Calendar.getInstance()
//        options.add(formatter.format(calendar.time))
//        calendar.add(Calendar.DATE, 1)
//        return options
//
//    }
    fun updateDate(time: String) {
        _date.value = time
    }




//    fun setTitle(titleValue: String ) {
//        _title.value = titleValue
//    }
//    fun setSubTitle(subTitleValue: String){
//        _subTitle.value = subTitleValue
//    }
//    fun setData(dateValue: String?){
//        _date.value = dateValue
//    }
//



}

