package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.data.Item
import com.example.havesomerest.R
import kotlinx.android.synthetic.main.fragment_item_list.*

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private val exampleList = generateDummyList(500)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.apply{
            list.adapter = MyItemRecyclerViewAdapter(exampleList)
            list.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun generateDummyList(size:Int) : List<Item>
    {
        val list = ArrayList<Item>()

        for (i in 0 until size)
        {
            val item = Item(R.drawable.ic_baseline_add_24,"Item $i", "Line 2")
            list += item
        }

        return list
    }
}