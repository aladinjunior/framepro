package com.aladin.framepro.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.R
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.RegistersListItemBinding
import com.aladin.framepro.extensions.oval

class RegistersAdapter(private val onRegisterClick: (register: Register) -> Unit) : RecyclerView.Adapter<RegistersAdapter.RegistersViewHolder>(){


    val listOfRegisters: MutableList<Register> = mutableListOf()


    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Register>){
        listOfRegisters.clear()
        listOfRegisters.addAll(newList)
        notifyDataSetChanged()
    }

    fun removeRegister(position: Int) {
        listOfRegisters.removeAt(position)
        notifyItemRemoved(position)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RegistersListItemBinding.inflate(layoutInflater, parent, false)
        return RegistersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegistersViewHolder, position: Int) {
        holder.bind(listOfRegisters[position])
    }

    override fun getItemCount(): Int {
        return listOfRegisters.size
    }

    inner class RegistersViewHolder(private val binding: RegistersListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(register: Register){
            with(binding){
                textImage.text = register.name.first().toString().uppercase()
                textImage.background = itemView.oval(itemView.context.getColor(R.color.purple_darker))
                name.text = register.name.uppercase()
                address.text = register.address
            }
            itemView.setOnClickListener {
                onRegisterClick.invoke(register)
            }

        }
    }

}