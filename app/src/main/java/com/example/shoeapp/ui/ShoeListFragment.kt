package com.example.shoeapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.activity.addCallback
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.shoeapp.R
import com.example.shoeapp.databinding.FragmentShoeDetailsBinding
import com.example.shoeapp.databinding.FragmentShoeListBinding
import com.example.shoeapp.databinding.ItemShoesBinding
import com.example.shoeapp.models.ShoeModel
import com.example.shoeapp.viewmodel.ShoeViewModel


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.loginFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentShoeListBinding.inflate(layoutInflater)
        return binding.root
       // return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        getAllShoe()

        binding.addShoeBtn.setOnClickListener {
            viewModel.clearAddingShoeSession()
            findNavController().navigate(R.id.shoeDetailsFragment)
        }
    }

    private fun getAllShoe(){
        viewModel.getShoeLiveData().observe(viewLifecycleOwner) {
            it?.forEach { shoe ->
                binding.shoesListLayout.addView(getViewForShoe(shoe))
            }
        }
    }


    private fun getViewForShoe(shoe: ShoeModel): View{
        val itemShoesBinding = ItemShoesBinding.inflate(LayoutInflater.from(requireContext()),null,false)
        itemShoesBinding.tvName.text = shoe.name
        itemShoesBinding.tvCompany.text = shoe.company
        itemShoesBinding.tvSize.text = shoe.size.toString()
        itemShoesBinding.tvDesc.text = shoe.description

        itemShoesBinding.executePendingBindings()
        return itemShoesBinding.root
    }


    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {


            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.shoe_list_menue, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                findNavController().navigate(R.id.loginFragment)
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}