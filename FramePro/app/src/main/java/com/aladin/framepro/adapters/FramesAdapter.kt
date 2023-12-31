package com.aladin.framepro.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.domain.model.FrameView
import com.aladin.framepro.databinding.FramesListItemBinding
import com.aladin.framepro.domain.model.initialFrames
import com.bumptech.glide.Glide
import kotlin.coroutines.coroutineContext

class FramesAdapter(private val context: Context, private val frameViews: MutableList<FrameView>, private val onFrameClick: (name: String) -> Unit) : RecyclerView.Adapter<FramesAdapter.FramesViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<FrameView>){
        frameViews.clear()
        frameViews.addAll(initialFrames(context))
        frameViews.addAll(list)
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

                Glide.with(itemView.context)
                    .load(frameView.imgCover)
                    .into(frameCover)

                itemView.setOnClickListener {
                    onFrameClick(frameView.name)
                }

            }
        }
    }
}