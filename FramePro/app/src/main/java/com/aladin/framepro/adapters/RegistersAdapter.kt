package com.aladin.framepro.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.data.models.Register
import com.aladin.framepro.databinding.RegistersListItemBinding

class RegistersAdapter : RecyclerView.Adapter<RegistersAdapter.RegistersViewHolder>(){


    private val listOfRegisters: MutableList<Register> = mutableListOf()


    fun setList(newList: List<Register>){
        listOfRegisters.clear()
        listOfRegisters.addAll(newList)
        notifyDataSetChanged()
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
                name.text = register.name
                address.text = register.address
            }
        }
    }

}