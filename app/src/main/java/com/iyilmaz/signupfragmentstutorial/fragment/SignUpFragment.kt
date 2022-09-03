package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentSignUpBinding
import com.iyilmaz.signupfragmentstutorial.entity.Person


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
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


            btnContinue.setOnClickListener {

                val direction =
                    SignUpFragmentDirections.actionSignUpFragmentToApproveInputFragment(
                        Person(
                            etName.text.toString(),
                            etSurname.text.toString(),
                            etUsername.text.toString(),
                            etDate.text.toString(),
                            etPassword.text.toString(),
                            onClickButton(),
                            null,
                            null,
                            null,
                            null
                        )
                    )
                findNavController().navigate(direction)
            }
            imageButton.setOnClickListener {
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        etDate.setText(date)
                    }
                }
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        }//binding.apply//
    }
    private fun onClickButton(): String {
        return binding.root
            .findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
            .text.toString()
    }
}