package com.aladin.framepro.adapters

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.viewmodel.RegisterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SwipeRegister(private val registerAdapter: RegistersAdapter,
    private val registerViewModel: RegisterViewModel) :
    ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.LEFT
    ) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        val register = registerAdapter.listOfRegisters[position]

        try {
            registerViewModel.viewModelScope.launch(Dispatchers.IO) {
                registerViewModel.deleteRegister(register)
                Log.i("roomdb", "deleted")
            }
        } catch (e: Exception) {
            Log.e("roomdb", "Error deleting register: ${e.message}")
        }

        registerAdapter.removeRegister(position)
    }
}