package com.example.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.data.Repository
import com.example.havesomerest.R
import com.example.models.MainViewModel
import com.example.models.MainViewModelFactory
import com.example.models.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * A fragment representing a list of Items.
 */
class ListFragment : Fragment() {
    val adapter = MyItemRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.getAllRestaurants(1411)
        viewModel.mAllRestaurants.observe(this, Observer { response ->
            if(response.isSuccessful) {
                response.body()?.let {
                    adapter.setData(it.restaurants)
                }
                response.body()!!.restaurants.forEach {
                    Log.d("Response", it.name)
                    Log.d("Response", it.address)
                }
            }else {
                Log.d("Response", response.errorBody().toString())
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = view.list

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        view.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_profileFragment)
        }

        return view
    }


}