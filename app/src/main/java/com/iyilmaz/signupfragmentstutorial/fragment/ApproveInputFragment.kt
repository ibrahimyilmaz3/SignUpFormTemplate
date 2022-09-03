package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentApproveInputBinding
import com.iyilmaz.signupfragmentstutorial.entity.Person

class ApproveInputFragment : Fragment() {
    private lateinit var binding: FragmentApproveInputBinding
    private val args: ApproveInputFragmentArgs by navArgs()

    lateinit var person: Person
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApproveInputBinding.inflate(inflater, container, false)
        person = args.person

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            "${person.name}${person.surname}${person.username}${person.date}${person.password}${person.gender}".also {
                tvShow.text = it
            }
        }
    }
}