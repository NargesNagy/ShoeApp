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
       set(value) {
          field = value
          notifyPropertyChanged(BR.name)
       }

    @get:Bindable
    var company: String? = null
       set(value) {
          field = value
          notifyPropertyChanged(BR.company)
       }

    @get:Bindable
    var description: String? = null
       set(value) {
          field = value
          notifyPropertyChanged(BR.description)
       }


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

