package com.example.todolist.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.Date.userBasrfTask
import java.util.*

//--------------------------Adapter Model-----------------//
var coreID = 0

data class TaskData(var title: String? = "", var subTitle: String? = "", var date: String? = "",
                    var importing: Boolean, var id: Int = coreID++, var timeCompare: Long = 0)

//--------------------View Model-------------------------//
class ToDoViweModel : ViewModel() {
    val title = MutableLiveData<String>("")
    val subTitle = MutableLiveData<String>("")
    val date = MutableLiveData<String>("")
    val comblet = MutableLiveData<Boolean>(false)
    val timeCompare = MutableLiveData<Long>(0)
    val taxtTaskTime = MutableLiveData<String>()

    //------------------------------------
//-------------------------------------
    fun addTask() {
        userBasrfTask.add(TaskData(title.value, subTitle.value, date.value, comblet.value!!))
    }

    fun EditTask(indext: Int) {

        userBasrfTask.set(indext, TaskData(title.value, subTitle.value, date.value, comblet.value!!))


    }

    fun RemoveTask(indext: Int) {
        userBasrfTask.removeAt(indext)
    }

    fun updateDate(dataUP: String) {
        date.value = dataUP
    }

    fun updateCurrentData(taskID: Int) {
        val task = userBasrfTask.find { it.id == taskID }
        title.value = task?.title
        date.value = task?.date
        subTitle.value = task?.subTitle
        comblet.value = task?.importing
    }

    fun camperBetweenTime(camper: Long) {
        timeCompare.value = camper
    }


    fun RasetTextView() {
        TaskTime()
    }

    fun resetTask() {
        title.value = ""
        subTitle.value = ""
        date.value = ""
        comblet.value = false
        timeCompare.value = 0
        taxtTaskTime.value = ""
    }

    fun TaskTime() {
        Log.e("TAG", "in TaskTime outer value :${taxtTaskTime.value} ")
        // log
        if (date.value == "") {
            //
            taxtTaskTime.value = "Pick a Time"
            Log.e("TAG", "in TaskTime outer if value:${taxtTaskTime.value} ")
        } else if (timeCompare.value!!.toLong() < Calendar.getInstance().timeInMillis) {
            //
            taxtTaskTime.value = "Time up"
            Log.e("TAG", "in TaskTime outer if else value:${taxtTaskTime.value} ")
        } else {
            //
            taxtTaskTime.value = "there is still time"
            Log.e("TAG", "in TaskTime outer else value: ")
        }
    }


}

