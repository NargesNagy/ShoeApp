package com.example.shoeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.R
import com.example.shoeapp.databinding.FragmentInstractionsBinding
import com.example.shoeapp.databinding.FragmentWelcomeBinding


class InstractionsFragment : Fragment() {

    private lateinit var binding: FragmentInstractionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentInstractionsBinding.inflate(layoutInflater)
        return binding.root
       // return inflater.inflate(R.layout.fragment_instractions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheckInstructions.setOnClickListener {
            findNavController().navigate(R.id.shoeListFragment)

        }
    }

}