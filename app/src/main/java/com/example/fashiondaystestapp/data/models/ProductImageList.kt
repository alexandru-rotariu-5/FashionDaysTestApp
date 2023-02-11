package com.example.fashiondaystestapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductImageList(
    @Json(name = "thumb") val thumb: List<String>,
    @Json(name = "zoom") val zoom: List<String>
)