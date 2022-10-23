package com.example.shoeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import com.example.shoeapp.R
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
     //   return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {

             if (binding.etPassword.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "please enter password", Toast.LENGTH_SHORT).show()
            } else if (binding.etEmail.text?.contains('@') == false || binding.etEmail.text.isNullOrEmpty() == true){
                Toast.makeText(requireContext(), "please enter valid mail", Toast.LENGTH_SHORT).show()

            }else{
                 findNavController().navigate(R.id.welcomeFragment)

             }

        }
        binding.btnSignup.setOnClickListener {

            if (binding.etPassword.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "please enter password", Toast.LENGTH_SHORT).show()
            } else if (binding.etEmail.text?.contains('@') == false || binding.etEmail.text.isNullOrEmpty() == true){
                Toast.makeText(requireContext(), "please enter valid mail", Toast.LENGTH_SHORT).show()

            }else{
                findNavController().navigate(R.id.welcomeFragment)

            }
        }
    }

}