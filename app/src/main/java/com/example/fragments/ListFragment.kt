package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.havesomerest.R
import com.example.models.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * A fragment representing a list of Items.
 */
class ListFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = MyItemRecyclerViewAdapter()
        val recyclerView = view.list

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user-> adapter.setData(user)})

        view.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_profileFragment)
        }

        return view
    }


}