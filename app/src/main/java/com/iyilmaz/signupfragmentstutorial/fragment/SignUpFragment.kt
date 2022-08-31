package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentSignUpBinding
import com.iyilmaz.signupfragmentstutorial.entity.Person


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    lateinit var person: Person
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            //set on click
            btnContinue.setOnClickListener {
                val direction =
                    SignUpFragmentDirections.actionSignUpFragmentToApproveInputFragment(
                        Person(
                            etName.text.toString(),
                            etSurname.text.toString(),
                            etUsername.text.toString(),
                            etDate.text.toString(),
                            etPassword.text.toString(),
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                    )
                findNavController().navigate(direction)

            }
            imageButton.setOnClickListener {
                myCalendar(view)
            }

            datePicker.setOnDateChangedListener {
                datePicker,day,month,year ->
                etDate.setText(datePicker())
                datePicker.visibility = View.GONE
            }

            etDate.setText(datePicker())
        }
    }

    fun datePicker(): String {
        val day = binding.datePicker.dayOfMonth.toString().padStart(2,'0')
        val month = binding.datePicker.month.toString().padStart(2,'0')
        val year = binding.datePicker.year.toString().padStart(4,'0')
        return "$day/$month/$year"
    }

    fun myCalendar(view: View) {
        binding.datePicker.visibility = View.VISIBLE
    }

}