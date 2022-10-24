package com.example.shoeapp.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.parcelize.Parcelize
import com.example.shoeapp.BR

@Parcelize
 class ShoeModel : Parcelable , BaseObservable(){
    @get:Bindable
    var name: String? = null


    @get:Bindable
    var company: String? = null


    @get:Bindable
    var description: String? = null


    @get:Bindable
    var size: Double? = 0.0

   fun setSize(value: String?) {
      this.size = if (value.isNullOrEmpty()){
         0.0
      }else {
         value.toDouble()
      }
      notifyPropertyChanged(BR.size)
   }


}

