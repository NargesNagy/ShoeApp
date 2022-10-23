package com.example.shoeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.shoeapp.R
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.databinding.FragmentLoginBinding
import com.example.shoeapp.databinding.FragmentShoeDetailsBinding
import com.example.shoeapp.models.ShoeModel
import com.example.shoeapp.viewmodel.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentShoeDetailsBinding.inflate(layoutInflater)
        return binding.root
       // return inflater.inflate(R.layout.fragment_shoe_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCancle.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnSave.setOnClickListener {

            if (binding.etName.text.isNullOrEmpty() || binding.etCopmany.text.isNullOrEmpty() || binding.etSize.text.isNullOrEmpty() || binding.etDesc.text.isNullOrEmpty() ) {
                Toast.makeText(requireContext(), "please enter valid data", Toast.LENGTH_SHORT)
                    .show()
            } else{
                val name = binding.etName.text.toString()
                val company = binding.etCopmany.text.toString()
                val size = Integer.parseInt(binding.etSize.text.toString())
                val description = binding.etDesc.text.toString()
                viewModel.validateData(name, company, size, description)
                val newShoe = ShoeModel(name, size, company, description)
                viewModel.addShoe(newShoe)


                findNavController().navigate(R.id.shoeListFragment)
            }


        }
    }

}