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
import androidx.lifecycle.get
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

        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }

        view.listButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_listFragment)
        }

        /**
        view.listButton.setOnClickListener {
            TODO("Not implemented, yet!")
        }
        */

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = editTextFirstName.text.toString()
        val lastName = editTextLastName.text.toString()
        val age = editTextAge.text

        if(inputCheck(firstName,lastName,age)) {
            val user = User(0,firstName,lastName,Integer.parseInt(age.toString()))

//            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "Fail!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName:String, lastName:String, age:Editable) : Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}