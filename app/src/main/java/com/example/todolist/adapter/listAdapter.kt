package com.example.todolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Date.DateSource
import com.example.todolist.ListOfToDoDirections
import com.example.todolist.R

class ListAdapter(private val context:Context?):
    RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {
    private val dateset = DateSource().loadNote()



    class ItemViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textTitle : TextView = view.findViewById(R.id.titleName)
        val textSubTitle : TextView = view.findViewById(R.id.subTitleName)
        val textDate : TextView = view.findViewById(R.id.datelist)
        val cerdView : CardView = view.findViewById(R.id.cerdView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.todo_dit,parent,false)
        return ItemViewHolder(adapterLayout)}

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = dateset[position]

        holder.textTitle.text = note.title
        holder.textSubTitle.text = note.subTitle
        holder.textDate.text = note.date
        holder.cerdView.setOnClickListener {
            val actionCard = ListOfToDoDirections.actionListOfToDoToEditToDo()
            holder.itemView.findNavController().navigate(actionCard)
        }

    }

    override fun getItemCount(): Int {
        return dateset.size
    }
}