package com.example.fragments

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.data.Restaurant
import com.example.data.User
import com.example.havesomerest.R
import kotlinx.android.synthetic.main.fragment_item.view.*

class MyItemRecyclerViewAdapter() : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private var values: List<Restaurant> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.fragment_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.name.text = item.name
        holder.address.text = item.address

        holder.row.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imageView)
        val name: TextView = view.findViewById(R.id.textViewName)
        val address: TextView = view.findViewById(R.id.textViewAddress)

        val row:ConstraintLayout = view.findViewById(R.id.rowLayout)
    }

    fun setData(newValues: List<Restaurant>) {
        values = newValues
        notifyDataSetChanged()
    }
}