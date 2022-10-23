package com.example.shoeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeModel(var name: String,
                     var size: Int,
                     var company: String,
                     var description: String ) : Parcelable
