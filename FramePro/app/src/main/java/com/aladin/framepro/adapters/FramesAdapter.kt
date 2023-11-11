package com.aladin.framepro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.databinding.FramesListItemBinding

class FramesAdapter : RecyclerView.Adapter<FramesAdapter.FramesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FramesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FramesListItemBinding.inflate(layoutInflater, parent, false)
        return FramesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FramesViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class FramesViewHolder(private val binding: FramesListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(frame: Frame){

        }
    }
}