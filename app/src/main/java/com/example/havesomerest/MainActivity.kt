package com.example.havesomerest

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.data.Repository
import com.example.fragments.ListFragment
import com.example.fragments.MyItemRecyclerViewAdapter
import com.example.models.MainViewModel
import com.example.models.MainViewModelFactory


class MainActivity : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}