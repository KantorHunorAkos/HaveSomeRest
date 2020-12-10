package com.example.fragments

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.data.User
import com.example.havesomerest.R
import kotlinx.android.synthetic.main.fragment_item.view.*

class MyItemRecyclerViewAdapter(
    //private val values: List<Item>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private var values = emptyList<User>()

    private val mOnClickListener: View.OnClickListener = View.OnClickListener {
        Log.d("onclick of item", "Clicked!")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        /**holder.image.setImageResource(item.image)
        holder.text1.text = item.text1
        holder.text2.text = item.text2*/

        holder.id.text = item.id.toString()
        holder.firstName.text =item.firstName
        holder.lastName.text = item.lastName
        holder.age.text = item.age.toString()

        /**
        with(holder.itemView) {
            setOnClickListener(mOnClickListener)
        }
        */

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = values.size

    /**
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_view)
        val text1: TextView = view.findViewById(R.id.text1)
        val text2: TextView = view.findViewById(R.id.text2)

    }
    */

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id:TextView = view.findViewById(R.id.textViewId)
        val firstName:TextView = view.findViewById(R.id.textViewFirstName)
        val lastName:TextView = view.findViewById(R.id.textViewLastName)
        val age:TextView =view.findViewById(R.id.textViewAge)
    }

    fun setData(user:List<User>) {
        this.values = user
        notifyDataSetChanged()
    }
}