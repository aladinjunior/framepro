package com.aladin.framepro.adapters

import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.aladin.framepro.viewmodels.RegisterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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

        GlobalScope.launch(Dispatchers.IO) {
            registerViewModel.delete(register)
            Log.i("roomdb", "deleted")
        }



        registerAdapter.removeRegister(position)
    }
}