package com.aladin.framepro.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.data.models.FrameDescription
import com.aladin.framepro.databinding.ResultFramesListItemBinding

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    private val listOfFrameDesc : MutableList<FrameDescription> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<FrameDescription>){
        listOfFrameDesc.clear()
        listOfFrameDesc.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ResultFramesListItemBinding.inflate(layoutInflater, parent, false)
        return ResultsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.bind(listOfFrameDesc[position])
    }

    override fun getItemCount(): Int {
        return listOfFrameDesc.size
    }

    inner class ResultsViewHolder(private val binding: ResultFramesListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(frameDescription: FrameDescription){

        }
    }
}