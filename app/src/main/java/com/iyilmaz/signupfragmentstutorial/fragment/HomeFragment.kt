package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iyilmaz.signupfragmentstutorial.R
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var  binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.buttonSignView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_signUpFragment)
        }
        binding.buttonRecyclerView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_movieRecyclerViewFragment)
        }

        return binding.root
    }

}