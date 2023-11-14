package com.aladin.framepro.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.databinding.FramesListItemBinding

class FramesAdapter(private val onFrameClick: (name: String) -> Unit) : RecyclerView.Adapter<FramesAdapter.FramesViewHolder>() {


    private val listOfFrames: MutableList<Frame> = mutableListOf()


    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Frame>){
        listOfFrames.clear()
        listOfFrames.addAll(newList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FramesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FramesListItemBinding.inflate(layoutInflater, parent, false)
        return FramesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FramesViewHolder, position: Int) {
        holder.bind(listOfFrames[position])
    }

    override fun getItemCount(): Int {
        return listOfFrames.size
    }

    inner class FramesViewHolder(private val binding: FramesListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(frame: Frame){
            with(binding){
                frameTitle.text = frame.name
                frameSubtitle.text = frame.subtitle
                frameCover.setImageResource(frame.imgCover)

                itemView.setOnClickListener {
                    onFrameClick.invoke(frame.name)
                }

            }
        }
    }
}