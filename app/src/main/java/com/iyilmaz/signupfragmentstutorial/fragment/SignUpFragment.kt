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
                            onClickButton(),
                            kotlinCheck(),
                            javaCheck(),
                            dartCheck(),
                            cSharpCheck()
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
            }//DatePicker
        }//binding.apply\\
    }

    private fun kotlinCheck(): String {
        val check4 = when (binding.cbKotlin.isChecked) {
            true -> binding.cbKotlin.text.toString()
            false -> ""
        }
        return check4
    }

    private fun javaCheck(): String {
        val check3 = when (binding.cbJava.isChecked) {
            true -> binding.cbJava.text.toString()
            false -> ""
        }
        return check3
    }

    private fun dartCheck(): String {
        val check2 = when (binding.cbDart.isChecked) {
            true -> binding.cbDart.text.toString()
            false -> ""
        }
        return check2
    }

    private fun cSharpCheck(): String {
        val check1 = when (binding.cbCsharp.isChecked) {
            true -> binding.cbCsharp.text.toString()
            false -> ""
        }
        return check1
    }




    private fun onClickButton(): String {
        return binding.root
            .findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
            .text.toString()
    } //RadioButton
}