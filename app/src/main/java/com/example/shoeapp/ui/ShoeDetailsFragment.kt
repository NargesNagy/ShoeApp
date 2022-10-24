package com.example.shoeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.shoeapp.R
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.databinding.FragmentLoginBinding
import com.example.shoeapp.databinding.FragmentShoeDetailsBinding
import com.example.shoeapp.models.ShoeModel
import com.example.shoeapp.viewmodel.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentShoeDetailsBinding.inflate(layoutInflater)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        return binding.root
       // return inflater.inflate(R.layout.fragment_shoe_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener{

            if (binding.etName.text.isNullOrEmpty() || binding.etCopmany.text.isNullOrEmpty() || binding.etSize.text.isNullOrEmpty() || binding.etDesc.text.isNullOrEmpty() ) {
                Toast.makeText(requireContext(), "please enter valid data", Toast.LENGTH_SHORT).show()
                Toast.makeText(requireContext(), "${viewModel.newAddedShoe.size}", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.newAddedShoe.apply {
                    viewModel.addShoe(shoe = this)
                    findNavController().navigateUp()
                }
            }

        }


        binding.btnCancle.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}