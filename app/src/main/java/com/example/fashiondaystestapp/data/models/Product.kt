package com.example.fashiondaystestapp.data.models

import com.example.fashiondaystestapp.ui.models.ProductItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "product_id") val id: Int,
    @Json(name = "product_brand") val brand: String,
    @Json(name = "product_name") val name: String,
    @Json(name = "product_images") val images: ProductImageList
) {
    fun toProductItem(): ProductItem {
        return ProductItem(
            brand, name, images.thumb[0]
        )
    }
}
