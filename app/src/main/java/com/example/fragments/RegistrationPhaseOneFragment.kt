package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.havesomerest.R
import com.example.havesomerest.databinding.FragmentRegistrationPhaseOneBinding
import com.example.viewModels.RegistrationViewModel


class RegistrationPhaseOneFragment : Fragment() {
    private lateinit var binding : FragmentRegistrationPhaseOneBinding
    private val viewModel : RegistrationViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_registration_phase_one,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var user = viewModel.getUser()
        if (user!=null){
            binding.editTextTextEmailAddress.setText(user.email)
            binding.editTextTextPassword.setText(user.password)
            binding.editTextTextPassword2.setText(user.password)
        }
    }
}