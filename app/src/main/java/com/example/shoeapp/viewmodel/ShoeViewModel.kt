package com.example.shoeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoeapp.models.ShoeModel

class ShoeViewModel : ViewModel() {

    var isShouldValidateFields: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _shoeItemLiveData = MutableLiveData<MutableList<ShoeModel>?>(mutableListOf())

    var newAddedShoe = ShoeModel()

    fun addShoe(shoe: ShoeModel) {
        _shoeItemLiveData.value?.add(shoe)
        _shoeItemLiveData.value = _shoeItemLiveData.value
    }

    fun clearAddingShoeSession() {
        isShouldValidateFields.value = false
        newAddedShoe = ShoeModel()
    }

    fun getShoeLiveData(): LiveData<MutableList<ShoeModel>?> {
        return _shoeItemLiveData
    }



}
