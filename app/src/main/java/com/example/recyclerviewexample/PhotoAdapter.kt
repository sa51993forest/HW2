package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ActivitySecondPageBinding

class PhotoAdapter(val photoList: List<Photos>):RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ActivitySecondPageBinding):RecyclerView.ViewHolder(binding.root){
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ActivitySecondPageBinding.inflate(layoutInflater,parent,false)
        val viewHolder = ViewHolder(binding)
        return viewHolder
    }
    override fun getItemCount():Int{
        return photoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photoList[position]
        //holder.binding.Photo = photo
        //holder.binding.executePendingBindings()

    }
}