package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.havesomerest.R
import com.example.havesomerest.databinding.FragmentSettingBinding
import com.example.viewModels.MyDatabaseViewModel


class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding
    private lateinit var myDatabaseViewModel: MyDatabaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this){
            findNavController().navigate(R.id.action_settingsFragment_to_mainMenuFragment)
        }

        myDatabaseViewModel = requireActivity().run {
            ViewModelProvider(requireActivity()).get(MyDatabaseViewModel::class.java)
        }

        binding.deleteCacheButton.setOnClickListener{
            deleteCache()
        }


    }


    //**************** PRIVATE FUNCTIONS ********************

    private fun deleteCache(){
        myDatabaseViewModel.deleteCache()
        findNavController().navigate(R.id.action_settingsFragment_to_splashScreenFragment)
    }

}