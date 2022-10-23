package com.example.shoeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeapp.models.ShoeModel

class ShoeViewModel : ViewModel() {

    private val _shoeListLiveData = MutableLiveData<List<ShoeModel>>()
    val shoeListResult: LiveData<List<ShoeModel>> = _shoeListLiveData
    private var shoeList = mutableListOf<ShoeModel>()

    fun addShoe(newShoe: ShoeModel) {
        newShoe.let { item ->
            shoeList.add(item)
            _shoeListLiveData.value = shoeList
        }
    }

    fun validateData(name: String, company: String, size: Int, description: String) {

    }
}
