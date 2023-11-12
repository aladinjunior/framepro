package com.aladin.framepro.adapters

import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.databinding.FramesListItemBinding
import com.aladin.framepro.extensions.setShadowLayer

class FramesAdapter(private val onFrameClick: (name: String) -> Unit) : RecyclerView.Adapter<FramesAdapter.FramesViewHolder>() {


    private val listOfFrames: MutableList<Frame> = mutableListOf()


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
                setShadowLayer(frame, frameCover)


                itemView.setOnClickListener {
                    onFrameClick(frame.name)
                }

            }
        }
    }
}