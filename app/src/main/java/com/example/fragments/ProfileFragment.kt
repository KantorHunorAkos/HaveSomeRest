package com.example.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.data.User
import com.example.havesomerest.R
import com.example.models.UserViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment: Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.listButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_listFragment)
        }

        view.updateButton.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToUpdateFragment(TODO())
            findNavController().navigate(action)
        }

        view.favButton.setOnClickListener {

        }

        return view
    }
}