package com.example.fashiondaystestapp.data.models

import com.google.gson.annotations.SerializedName

data class ProductImageList(
    @SerializedName("thumb") val thumb: ArrayList<String>,
    @SerializedName("zoom") val zoom: ArrayList<String>
)