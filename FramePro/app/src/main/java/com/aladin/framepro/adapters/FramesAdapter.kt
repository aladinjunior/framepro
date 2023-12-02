package com.aladin.framepro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.data.models.FrameView
import com.aladin.framepro.databinding.FramesListItemBinding

class FramesAdapter(private val frameViews: MutableList<FrameView>, private val onFrameClick: (name: String) -> Unit) : RecyclerView.Adapter<FramesAdapter.FramesViewHolder>() {


    fun updateList(frameView: FrameView) {
        frameViews.add(frameView)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FramesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FramesListItemBinding.inflate(layoutInflater, parent, false)
        return FramesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FramesViewHolder, position: Int) {
        holder.bind(frameViews[position])
    }

    override fun getItemCount(): Int {
        return frameViews.size
    }

    inner class FramesViewHolder(private val binding: FramesListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(frameView: FrameView){
            with(binding){
                frameTitle.text = frameView.name
                frameSubtitle.text = frameView.material
                frameCover.setImageURI(frameView.imgCover)

                itemView.setOnClickListener {
                    onFrameClick(frameView.name)
                }

            }
        }
    }
}