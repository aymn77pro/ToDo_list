package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Date.userBasrfList
import com.example.todolist.ListOfToDoDirections
import com.example.todolist.R
import com.example.todolist.databinding.FragmentListOfToDoBinding
import com.example.todolist.model.ToDoViweModel

class ListAdapter(context: FragmentListOfToDoBinding) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {
    val viewModel = ToDoViweModel()
    val dateset= userBasrfList
    class ItemViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textTitle : TextView = view.findViewById(R.id.titleName)
        val textSubTitle : TextView = view.findViewById(R.id.subTitleName)
        val textDate : TextView = view.findViewById(R.id.datelist)
        val cerdView : CardView = view.findViewById(R.id.cerdView)
        val complet: CheckBox = view.findViewById(R.id.completedlist)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.todo_dit,parent,false)
        return ItemViewHolder(adapterLayout)}

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = dateset[position]
        holder.textTitle.text = note.title.toString()
        holder.textSubTitle.text = note.subTitle.toString()
        holder.textDate.text = note.date.toString()
        holder.complet.isChecked=note.importing
        holder.cerdView.setOnClickListener {
            val actionCard = ListOfToDoDirections.actionListOfToDoToEditToDo(title = note.title.toString(),subTitle = note.subTitle.toString(),date = note.date.toString())
           holder.itemView.findNavController().navigate(actionCard)
        }

    }

    override fun getItemCount(): Int {
        return dateset.size
    }
}