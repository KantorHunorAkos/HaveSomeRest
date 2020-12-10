package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.havesomerest.R
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        view.textViewIdDetail.setText(args.item.id)
        view.textViewFirstNameDetail.text = args.item.firstName
        view.textViewLastNameDetail.text = args.item.lastName
        view.textViewAgeDetail.setText(args.item.age)

        return view
    }
}