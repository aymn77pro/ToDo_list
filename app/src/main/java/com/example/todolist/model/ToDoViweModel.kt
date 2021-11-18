package com.example.todolist.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.Date.userBasrfTask
import java.util.*

var coreID=0
data class TaskData(var title: String?="", var subTitle: String?="", var date: String?="",
                    var importing:Boolean, var id:Int= coreID++, var timeCompare: Long = 0)

class ToDoViweModel : ViewModel() {
    val title = MutableLiveData<String>("")
    val subTitle = MutableLiveData<String>("")
    val date = MutableLiveData<String>("")
    val comblet = MutableLiveData<Boolean>(false)
    val timeCompare = MutableLiveData<Long>(0)
    val taxtTaskTime = MutableLiveData<String>()



    fun addTask() {
        userBasrfTask.add(TaskData(title.value,subTitle.value,date.value, comblet.value!!))
    }
    fun EditTask(indext: Int){

 //       var task= userBasrfTask.find { it.id==indext }
//        title.value=task?.title
//        date.value = task?.date
//        subTitle.value=task?.subTitle
//        comblet.value=task?.importing
        userBasrfTask.set(indext,TaskData(title.value,subTitle.value,date.value, comblet.value!!))


    }
    fun RemoveTask(indext: Int){
        userBasrfTask.removeAt(indext)
    }

    fun updateDate(dataUP: String) {
    date.value = dataUP
    }

fun updateCurrentData(taskID:Int){
    var task= userBasrfTask.find { it.id==taskID }
    title.value=task?.title
    date.value = task?.date
    subTitle.value=task?.subTitle
    comblet.value=task?.importing
}
fun camperBetweenTime(camper:Long){
    timeCompare.value = camper
}



fun RasetTextView(){
    taxtTaskTime.value=""
}

fun resetTask(){
    title.value=""
    subTitle.value=""
    date.value=""
    timeCompare.value=0
    taxtTaskTime.value = ""
}
    fun TaskTime() {
        val x =  if (date.value ==""){
         taxtTaskTime.value="Pick a Time"}
        else if (timeCompare.value!!.toLong() < Calendar.getInstance().timeInMillis) {
         taxtTaskTime.value="Time up"
        }
        else {
           taxtTaskTime.value="there is still time"
        }
    }


}

