package com.aladin.framepro.adapters

import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Frame
import com.aladin.framepro.databinding.FramesListItemBinding

class FramesAdapter : RecyclerView.Adapter<FramesAdapter.FramesViewHolder>() {


    val listOfFrames: MutableList<Frame> = mutableListOf()


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

                val bgDrawable = ContextCompat.getDrawable(itemView.context, R.drawable.pcorrer_4f)
                val layerDrawable = ContextCompat.getDrawable(itemView.context, R.drawable.img_background_shadows) as LayerDrawable
                layerDrawable.setDrawableByLayerId(R.id.covered_movie_background, bgDrawable)

                frameCover.setImageDrawable(layerDrawable)



            }
        }
    }
}