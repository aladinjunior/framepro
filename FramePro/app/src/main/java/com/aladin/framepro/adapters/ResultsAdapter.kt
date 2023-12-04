package com.aladin.framepro.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.R
import com.aladin.framepro.domain.model.Frame
import com.aladin.framepro.databinding.ResultFramesListItemBinding

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    private val listOfFrameDesc : MutableList<Frame> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Frame>){
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
        fun bind(frame: Frame){
            with(binding){
                name.text = frame.name
                description.text = frame.description
                measures.text = itemView.context.getString(R.string.measures_result, frame.width, frame.height)
            }
        }
    }
}