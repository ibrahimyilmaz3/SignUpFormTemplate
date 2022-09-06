package com.iyilmaz.signupfragmentstutorial.fragment

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iyilmaz.signupfragmentstutorial.R
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentSignUpBinding
import com.iyilmaz.signupfragmentstutorial.entity.Person

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private var isAllFieldsChecked: Boolean = false

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

                isAllFieldsChecked = checkAllFields()

                if (isAllFieldsChecked) {
                    val builder2 = AlertDialog.Builder(context)
                    builder2.setMessage("All input was appropriate!")
                    builder2.setTitle("Sign up successful!")
                    builder2.setCancelable(false)
                    builder2.setNeutralButton("Ok") { dialog, _ ->
                        dialog.cancel()
                        val direction =
                            SignUpFragmentDirections.actionSignUpFragmentToApproveInputFragment(
                                Person(
                                    etName.text.toString(),
                                    etSurname.text.toString(),
                                    etUsername.text.toString(),
                                    etDOB.text.toString(),
                                    onClickButton(),
                                    kotlinCheck(),
                                    javaCheck(),
                                    dartCheck(),
                                    cSharpCheck()
                                )
                            )
                        findNavController().navigate(direction)
                    }
                    val alertDialog2 = builder2.create()
                    alertDialog2.show()
                }
            }
            imageButton.setOnClickListener { datePicker() }//DatePicker
            etDOB.setOnClickListener { datePicker() }//DatePickerEdittext
        }//binding.apply\\
    }

    private fun FragmentSignUpBinding.datePicker() {
        val datePickerFragment = DatePickerFragment()
        val supportFragmentManager = requireActivity().supportFragmentManager

        supportFragmentManager.setFragmentResultListener(
            "REQUEST_KEY",
            viewLifecycleOwner
        ) { resultKey, bundle ->
            if (resultKey == "REQUEST_KEY") {
                val date = bundle.getString("SELECTED_DATE")
                etDOB.setText(date)
            }
        }
        datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
    }

    private fun checkAllFields(): Boolean {
        binding.etName.error = null
        binding.etSurname.error = null
        binding.etUsername.error = null
        binding.etDOB.error = null
        binding.etPassword.error = null
        binding.etConfirmPassword.error = null

        if (binding.etName.length() == 0) {
            binding.etName.error = "This field is required!"
            return false
        }
        if (binding.etSurname.length() == 0) {
            binding.etSurname.error = "This field is required!"
            return false
        }
        if (binding.etUsername.length() == 0) {
            binding.etUsername.error = "This field is required!"
            return false
        }

        if (binding.etDOB.length() == 0) {
            binding.etDOB.error = "This field is required!"
            return false
        }
        if (binding.etPassword.length() < 8) {
            binding.etPassword.error = "Password must be minimum 8 characters!"
            return false
        }
        if (binding.etConfirmPassword.length() < 8) {
            binding.etConfirmPassword.error = "Password must be minimum 8 characters!"
            return false
        }
        if (binding.etPassword.text.toString() != binding.etConfirmPassword.text.toString()) {
            binding.etPassword.error = "Passwords do no match!"
            binding.etConfirmPassword.error = "Passwords do no match!"
            binding.etPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0)
            binding.etConfirmPassword.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_error,
                0
            )
            return false
        }
        if (binding.radioGroup.checkedRadioButtonId == -1) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Please select gender!")
            builder.setTitle("Missing field!")
            builder.setCancelable(false)
            builder.setNeutralButton("Ok") { dialog, _ ->
                dialog.cancel()
            }
            val alertDialog = builder.create()
            alertDialog.show()
            return false
        }

        return true
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