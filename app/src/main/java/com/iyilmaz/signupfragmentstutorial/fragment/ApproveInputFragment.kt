package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentApproveInputBinding
import com.iyilmaz.signupfragmentstutorial.entity.Person

class ApproveInputFragment : Fragment() {
    private lateinit var binding: FragmentApproveInputBinding
    private val args: ApproveInputFragmentArgs by navArgs()
    private lateinit var person: Person
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

            if (!person.java.equals("")) person.java = "\n${person.java}"
            if (!person.dart.equals("")) person.dart = "\n${person.dart}"
            if (!person.cSharp.equals("")) person.cSharp = "\n${person.cSharp}"

            tvShowName.text = person.name
            tvShowSurname.text = person.surname
            tvShowCar.text = person.car
            tvShowCity.text = person.city
            tvShowUsername.text = person.username
            tvShowDOB.text = person.date
            tvShowGender.text = person.gender
            "${person.kotlin} ${person.java} ${person.dart} ${person.cSharp} ".also {
                tvShowSkills.text = it
            }
            btnGoBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}